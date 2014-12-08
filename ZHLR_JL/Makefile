#************************************************************************
#
#             File : Makefile
#        Author(s) : epkflar
#          Created : 2002-11-21
#
# Copyright (c) 2002 Telefonaktiebolaget LM Ericsson, Sweden.
# All rights reserved.
# The Copyright to the computer program(s) herein is the property of
# Telefonaktiebolaget LM Ericsson, Sweden.
# The program(s) may be used and/or copied with the written permission
# from Telefonaktiebolaget LM Ericsson or in accordance with the terms
# and conditions stipulated in the agreement/contract under which the
# program(s) have been supplied.
#
# $Revision$
# $Date$
#
# DESCRIPTION
#
#
#************************************************************************
-include $(INCLUDE_LEVEL)/Makefile.local
ifneq ($(LOCAL_CONFIG), TRUE)
#************************************************************************

#************************************************************************
# Fill in the subdirectory names here
#************************************************************************
SUBDIRS =

DONT_USE_CPP  = true
DONT_USE_SCRIPT = true

#************************************************************************
# Fill in your ASN1 sources here.
#************************************************************************
ASN1_SOURCES       =

#************************************************************************
# Fill in your processing code sources here.
#************************************************************************
PROCCODE_SOURCES   =

#************************************************************************
# Fill in your XML sources here.
#************************************************************************
XML_SOURCES        =

#************************************************************************
# Fill in your archive target and sources here.
#************************************************************************
ARCHIVE_TARGET       = #lib?.a
ARCHIVE_SOURCES.cc   =
ARCHIVE_SOURCES.c    =
ARCHIVE_SOURCES.g    =
ARCHIVE_SOURCES.a    =
ARCHIVE_SOURCES.idl  =

#************************************************************************
# Fill in your sharedlib target and sources here.
#************************************************************************
SHAREDLIB_TARGET      = #lib?.so
SHAREDLIB_SOURCES.cc  =
SHAREDLIB_SOURCES.c   =
SHAREDLIB_SOURCES.g   =
SHAREDLIB_SOURCES.a   =
SHAREDLIB_SOURCES.idl =

#************************************************************************
# Fill in your executable target and sources here.
#************************************************************************
EXECUTABLE_TARGET      =
EXECUTABLE_SOURCES.cc  =
EXECUTABLE_SOURCES.c   =
EXECUTABLE_SOURCES.g   =
EXECUTABLE_SOURCES.a   =
EXECUTABLE_SOURCES.idl =

#************************************************************************
# Fill in your java target and sources here.
#************************************************************************
CLASSES_SOURCES.java   =
CLASSES_SOURCES.idl    =
ANT_SOURCES.xml    = build.xml

#************************************************************************
# Fill in your jar target and sources here.
#************************************************************************
JAR_ARCHIVE_TARGET    =
JAR_ARCHIVE_SOURCES   =
JAR_ARCHIVE_MANIFEST  =
JAR_PACKAGE_TARGET    =
JAR_PACKAGE_SOURCES   =

#************************************************************************
# Fill in your libraryschema target and sources here.
#************************************************************************
LIBSCHEMA_TARGET                =
LIBSCHEMA_SOURCES.os            =

#************************************************************************
# Fill in your application schema target and sources here.
#************************************************************************
APPSCHEMA_TARGET                =
APPSCHEMA_SOURCES.os            =
APPSCHEMA_SOURCES.ldb           =

#########################################################################
# DISTRIBUTION SECTION
#########################################################################
DISTRIBUTE_LIB                  =
DISTRIBUTE_BIN                  =
DISTRIBUTE_INCLUDE_PREFIX       =
DISTRIBUTE_INCLUDE              =
DISTRIBUTE_DEPENDENTS           =
DISTRIBUTE_JAVA_CLASSES         =

#########################################################################
# DOC SECTION
#########################################################################
JAVADOC_DIRS                    =

#########################################################################
# TEST SECTION
#########################################################################

#************************************************************************
# Fill in the programs which shall be executed at 'make test'.
# The programs (TEST_PROGRAMS) shall return 0 (zero) if successfull.
# The programs (TEST_PROGRAMS_OUTPUT) are executed with no result check,
# use this with another check-program (e.g. 'testprograms').
#************************************************************************
TEST_PROGRAMS        =
TEST_PROGRAMS_OUTPUT =

#************************************************************************
# Fill in your test archive target and sources here.
#************************************************************************
TEST_ARCHIVE_TARGET             = #lib?.a
TEST_ARCHIVE_SOURCES.cc         =
TEST_ARCHIVE_SOURCES.c          =
TEST_ARCHIVE_SOURCES.a          =
TEST_ARCHIVE_SOURCES.idl        =

#************************************************************************
# Fill in your test sharedlib target and sources here.
#************************************************************************
TEST_SHAREDLIB_TARGET           = #lib?.so
TEST_SHAREDLIB_SOURCES.cc       =
TEST_SHAREDLIB_SOURCES.c        =
TEST_SHAREDLIB_SOURCES.a        =
TEST_SHAREDLIB_SOURCES.idl      =

#************************************************************************
# Fill in your test executable target and sources here.
#************************************************************************
TEST_EXECUTABLE_TARGETS.cc      =
TEST_EXECUTABLE_SOURCES.cc      =
TEST_EXECUTABLE_SOURCES.c       =
TEST_EXECUTABLE_SOURCES.a       =
TEST_EXECUTABLE_SOURCES.idl     =

#************************************************************************
# Fill in your test java target and sources here.
#************************************************************************
TEST_CLASSES_SOURCES.java       =
TEST_CLASSES_SOURCES.idl        =

#************************************************************************
# Fill in your test application schema target and sources here.
#************************************************************************
TEST_APPSCHEMA_TARGET           =
TEST_APPSCHEMA_SOURCES.os       =
TEST_APPSCHEMA_SOURCES.ldb      =


#########################################################################
# COMPILATION PARAMETERS
#########################################################################
include ${MACS_HOME}/make/def.mk
INCLUDE_LEVEL = .
include config.mk
#########################################################################
#
# All parameters entered below will be appended to
# the parameters set in the config.mk file if += is used
# If = is used the config.mk parameters will be overwriten.
#
#########################################################################


#************************************************************************
# Fill in the general parameters here
#************************************************************************
PATHS.h        +=
PATHS.hh       +=
PATHS.java     +=
PATHS.idl      +=
PATHS.os       +=
PATHS.ldb      +=
PATHS.ld       +=
FLAGS.cc       +=
FLAGS.c        +=
FLAGS.antlr.g  +=
FLAGS.dlg.g    +=
FLAGS.java     +=
FLAGS.idl      +=
FLAGS.os       +=
FLAGS.ldb      +=
FLAGS.ld       +=

#************************************************************************
# Fill in the archive parameters here.
#************************************************************************
ARCHIVE_PATHS.hh      +=
ARCHIVE_PATHS.h       +=
ARCHIVE_PATHS.idl     +=
ARCHIVE_PATHS.ld      +=
ARCHIVE_FLAGS.cc      +=
ARCHIVE_FLAGS.c       +=
ARCHIVE_FLAGS.antlr.g +=
ARCHIVE_FLAGS.dlg.g   +=
ARCHIVE_FLAGS.idl     +=
ARCHIVE_FLAGS.ld      +=

#************************************************************************
# Fill in the sharedlib parameters here.
#************************************************************************
SHAREDLIB_PATHS.hh         +=
SHAREDLIB_PATHS.h          +=
SHAREDLIB_PATHS.idl        +=
SHAREDLIB_PATHS.ld         +=
SHAREDLIB_FLAGS.cc         +=
SHAREDLIB_FLAGS.c          +=
SHAREDLIB_FLAGS.antlr.g    +=
SHAREDLIB_FLAGS.dlg.g      +=
SHAREDLIB_FLAGS.idl        +=
SHAREDLIB_FLAGS.ld         +=
SHAREDLIB_LIBS.ld          +=
SHAREDLIB_NODEPENDLIBS.ld  +=

#************************************************************************
# Fill in the executable parameters here.
#************************************************************************
EXECUTABLE_PATHS.hh        +=
EXECUTABLE_PATHS.h         +=
EXECUTABLE_PATHS.idl       +=
EXECUTABLE_PATHS.ld        +=
EXECUTABLE_FLAGS.cc        +=
EXECUTABLE_FLAGS.c         +=
EXECUTABLE_FLAGS.antlr.g   +=
EXECUTABLE_FLAGS.dlg.g     +=
EXECUTABLE_FLAGS.idl       +=
EXECUTABLE_FLAGS.ld        +=
EXECUTABLE_LIBS.ld         +=
EXECUTABLE_NODEPENDLIBS.ld +=

#************************************************************************
# Fill in the java parameters here.
#************************************************************************
CLASSES_PATHS.java  +=
CLASSES_PATHS.idl   +=
CLASSES_FLAGS.java  +=
CLASSES_FLAGS.idl   +=

#************************************************************************
# Fill in the library schema parameters here.
#************************************************************************
LIBSCHEMA_PATHS.so   +=
LIBSCHEMA_FLAGS.so   +=

#************************************************************************
# Fill in the application schema parameters here.
#************************************************************************
APPSCHEMA_PATHS.so   +=
APPSCHEMA_FLAGS.so   +=
APPSCHEMA_PATHS.ldb  +=
APPSCHEMA_FLAGS.ldb  +=

#************************************************************************

export IT_CONFIG_PATH  = .

#************************************************************************
# Fill in the general test parameters here
#************************************************************************
TEST_PATHS.h      +=
TEST_PATHS.hh     +=
TEST_PATHS.java   +=
TEST_PATHS.idl    +=
TEST_PATHS.os     +=
TEST_PATHS.ldb    +=
TEST_PATHS.ld     +=
TEST_FLAGS.cc     +=
TEST_FLAGS.c      +=
TEST_FLAGS.java   +=
TEST_FLAGS.idl    +=
TEST_FLAGS.os     +=
TEST_FLAGS.ldb    +=
TEST_FLAGS.ld     +=

#************************************************************************
# Fill in the test archive parameters here.
#************************************************************************
TEST_ARCHIVE_PATHS.hh  +=
TEST_ARCHIVE_PATHS.h   +=
TEST_ARCHIVE_PATHS.idl +=
TEST_ARCHIVE_PATHS.ld  +=
TEST_ARCHIVE_FLAGS.cc  +=
TEST_ARCHIVE_FLAGS.c   +=
TEST_ARCHIVE_FLAGS.ld  +=

#************************************************************************
# Fill in the test sharedlib parameters here.
#************************************************************************
TEST_SHAREDLIB_PATHS.hh        +=
TEST_SHAREDLIB_PATHS.h         +=
TEST_SHAREDLIB_PATHS.idl       +=
TEST_SHAREDLIB_PATHS.ld        +=
TEST_SHAREDLIB_FLAGS.cc        +=
TEST_SHAREDLIB_FLAGS.c         +=
TEST_SHAREDLIB_FLAGS.idl       +=
TEST_SHAREDLIB_FLAGS.ld        +=
TEST_SHAREDLIB_LIBS.ld         +=
TEST_SHAREDLIB_NODEPENDLIBS.ld +=

#************************************************************************
# Fill in the test executable parameters here.
#************************************************************************
TEST_EXECUTABLE_PATHS.hh        +=
TEST_EXECUTABLE_PATHS.h         +=
TEST_EXECUTABLE_PATHS.idl       +=
TEST_EXECUTABLE_PATHS.ld        +=
TEST_EXECUTABLE_FLAGS.cc        +=
TEST_EXECUTABLE_FLAGS.c         +=
TEST_EXECUTABLE_FLAGS.idl       +=
TEST_EXECUTABLE_FLAGS.ld        +=
TEST_EXECUTABLE_LIBS.ld         +=
TEST_EXECUTABLE_NODEPENDLIBS.ld +=

#************************************************************************
# Fill in the test java parameters here.
#************************************************************************
TEST_CLASSES_PATHS.java  +=
TEST_CLASSES_PATHS.idl   +=
TEST_CLASSES_FLAGS.java  +=
TEST_CLASSES_FLAGS.idl   +=

#************************************************************************
# Fill in the test application schema parameters here.
#************************************************************************
TEST_APPSCHEMA_PATHS.so   +=
TEST_APPSCHEMA_FLAGS.so   +=
TEST_APPSCHEMA_PATHS.ldb  +=
TEST_APPSCHEMA_FLAGS.ldb  +=

#########################################################################
include ${MACS_HOME}/make/defmake.mk
#########################################################################

#************************************************************************
endif
LOCAL_CONFIG = FALSE
# **********************************************************************
# REVISION HISTORY
#
#  $Log$
# **********************************************************************
