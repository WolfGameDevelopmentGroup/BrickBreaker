#!/bin/bash
#
# Makefile
# 
# Objetivo: Compilação do teste da game Engine.
# 
# Site: http://www.dirackslounge.online
# 
# Versão 1.0
# 
# Programador: Rodolfo Dirack 05/09/2019
# 
# Email (Manutenção): rodolfo_profissional@hotmail.com
# 
# Licença: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.

CC = javac
PAC = ../../BrickBreaker/Game.java
DEP = $(PAC:.java=.class)
MAIN = Main.java
MAINCLASS = $(MAIN:.java=.class)
BIN = $(MAIN:.java=)

all:	$(DEP) $(MAINCLASS) run

libbed:	$(DEP)

run:	$(MAINCLASS)
	java $(BIN)

$(DEP):	$(PAC)
	$(CC) $< -d .

$(MAINCLASS):	$(MAIN)
	$(CC) $< -d .

clean:
	rm $(DEP)
	rm *.class
