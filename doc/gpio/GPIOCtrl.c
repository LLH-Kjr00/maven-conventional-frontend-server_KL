#include "GPIOCtrl.h"
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <string.h>

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_cmt_util_gpio_GPIOCtrl
 * Method:    GetPin
 * Signature: ()B
 */
JNIEXPORT jbyte JNICALL Java_com_cmt_util_gpio_GPIOCtrl_GetPin
  (JNIEnv *env, jobject obj){
	jbyte result = 0;
	int PortDev = open("/dev/port", O_RDWR | O_SYNC);
	int ret = 0;
	int i = 0;
	unsigned char gpio_data = 0;
	unsigned char super_io_enable[4] = { 0x87, 0x01, 0x55, 0x55 };
	unsigned char super_io_disable_2e = 0x02;
	unsigned char super_io_disable_2f = 0x02;

	if (PortDev == -1)
	{
		printf("Could not open device.\n");
	} else {
		printf("Open device successfully.\n");
	}

	printf("Unlock, enter super IO space.\n");

	// unlock, and enter super IO space
	if (lseek(PortDev, 0x2e, SEEK_SET) == -1) {
		printf("Seek to 0x2e failed, err[%d][%s]\n", errno, strerror(errno));
	} else {
		for (i = 0; i < 4; i++) {
			if (write(PortDev, (void *)&super_io_enable[i], 1) == -1) {
				printf("%d: Write [0x%02x] failed, err[%d][%s]\n", 
					i, super_io_enable[i], errno, strerror(errno));
			}
		}
	}

	printf("Read GPIO value.\n");

	// go to port 
	if (lseek(PortDev, 0xa07, SEEK_SET) == -1) {
		printf("Seek to 0xa07 failed, err[%d][%s]\n", errno, strerror(errno));
	}

	// read pin value
	if (read(PortDev, &gpio_data, 1) == -1) {
		printf("Read failed, err[%d][%s]\n", errno, strerror(errno));
	} else {
		// TODO: need verify with hardware pin voltage level.
		printf("Read data [0x%02x]\n", gpio_data);
		result = (jbyte)gpio_data;
	}

	printf("Lock, exit super IO space.\n");

	// lock and exit super IO space
	if (lseek(PortDev, 0x2e, SEEK_SET) == -1) {
		printf("Seek to 0x2e failed, err[%d][%s]\n", errno, strerror(errno));
	} else {
		if (write(PortDev, (void *)&super_io_disable_2e, 1) == -1) {
			printf("Write 0x02 @ 0x2e failed, err[%d][%s]\n", 
				errno, strerror(errno));
		}
	}
	if (lseek(PortDev, 0x2f, SEEK_SET) == -1) {
		printf("Seek to 0x2f failed, err[%d][%s]\n", errno, strerror(errno));
	} else {
		if (write(PortDev, (void *)&super_io_disable_2f, 1) == -1) {
			printf("Write 0x02 @ 0x2f failed, err[%d][%s]\n", 
				errno, strerror(errno));
		}
	}

	printf("Test END.\n");

	if (PortDev != -1) {
		close(PortDev);
		PortDev = -1;
	}

	return result;
  }

#ifdef __cplusplus
}
#endif
