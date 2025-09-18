/*********************************************************************
 * Octopus Cards Limited
 *
 * File Name            : ocrl.h
 * Version (Linux)      : 1.0
 * Last Edit            : 27 Dec 2023
 *********************************************************************/
 
#ifndef _OCRL_H
#define _OCRL_H
#ifdef __cplusplus
extern "C" {
#endif
int Connect(char* comm);
void Disconnect(void);
int CmdExchange(char* reqJson, char* respJson, int len);
#ifdef __cplusplus
}
#endif
#endif

