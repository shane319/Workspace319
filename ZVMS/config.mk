#************************************************************************
#
#             File : config.mk
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
-include $(INCLUDE_LEVEL)/config.mk.local
ifneq ($(LOCAL_CONFIG), TRUE)
#*************************************************************************
-include $(INCLUDE_LEVEL)/product.mk
-include $(INCLUDE_LEVEL)/product.mk.local
#*************************************************************************

-include $(GLOBAL_CONFIG_MK)

DONT_USE_SCHEMA = TRUE
USE_BUSLOGIC = TRUE
USE_BUSLOGIC_VERSION = TRUE

# Now, when we have included product.mk, we can modify our variables according
# to the configured products...
#*************************************************************************
#************************************************************************

##########################################################################
# START: Only in main config.mk
#
#*************************************************************************
# PATHS
#************************************************************************
# Fill in the general parameters here
#************************************************************************
PATHS.asn1 = -I$(MACS_MIRROR)/asn.1 -I$(FSCPROCENGINEHOME)/include/typeRepository -I$(FSCCMISEHOME)/include/asn.1 -I$(SOGGENERALHOME)/include/asn.1

PATHS.ipc = -i$(MACS_MIRROR)/ne -i$(MACS_MIRROR)/cluster

PATHS.funclib = -L$(FSCPROCENGINEHOME)/lib -L$(FSCUTILFUNCTIONSHOME)/lib -L${FSCNEROUTERHOME}/lib

PATHS.h = -I$(CXXHOME)/include/cc -I/usr/include -I/usr/include/sys -I${MACS_MIRROR} -I${MACS_BASELINE}

PATHS.hh = -I$(CXXHOME)/include/CC -I$(VISIBROKERHOME)/include -I$(ROGUEHOME)/include -I$(ROGUEHOME) -I${MACS_MIRROR} -I${MACS_BASELINE} -I$(FDSGENERALHOME)/include -I$(FDSCOREHOME)/include -I$(FSCMRLHOME)/include

PATHS.java      =       $(MACS_MIRROR)/ \
                        $(MACS_MIRROR)/_$(MACS_TARGET)/classes \
                        $(MACS_BASELINE)/_$(MACS_TARGET)/classes
PATHS.idl = $(PATHS.hh)
PATHS.os = $(PATHS.hh)
PATHS.ldb = -L${MACS_MIRROR}/_${MACS_TARGET}/lib -L${MACS_BASELINE}/_${MACS_TARGET}/lib -L$(FDSGENERALHOME)/lib -L$(OSTOREHOME)/lib

PATHS.ld = -L${MACS_MIRROR}/_${MACS_TARGET}/lib -L${MACS_BASELINE}/_${MACS_TARGET}/lib -L$(CXXHOME)/lib -L$(ROGUEHOME)/lib -L$(PCCTSHOME)/lib -L$(VISIBROKERHOME)/lib -L$(FDSGENERALHOME)/lib -L$(FDSCOREHOME)/lib -L$(FSCMRLHOME)/lib


#************************************************************************
# Fill in the businesslogic parameters here.
#************************************************************************
SHAREDLIB_LIBS.mrlcc = -lfscenginefunctions -lStringFunctions -lNamedValueFunctions -lfscmrldupmethods -lNeRouterFunctions

FLAGS.cc        =
FLAGS.c         =
FLAGS.antlr.g   =
FLAGS.dlg.g     =
FLAGS.java      =
FLAGS.idl       =
FLAGS.os        =
FLAGS.ldb       =
FLAGS.ld        =

#************************************************************************
# Fill in the archive parameters here.
#************************************************************************
ARCHIVE_PATHS.hh                =
ARCHIVE_PATHS.h                 =
ARCHIVE_PATHS.idl               =
ARCHIVE_PATHS.ld                =
ARCHIVE_FLAGS.cc                =
ARCHIVE_FLAGS.c                 =
ARCHIVE_FLAGS.antlr.g           =
ARCHIVE_FLAGS.dlg.g             =
ARCHIVE_FLAGS.ld                =

#************************************************************************
# Fill in the sharedlib parameters here.
#************************************************************************
SHAREDLIB_PATHS.hh              =
SHAREDLIB_PATHS.h               =
SHAREDLIB_PATHS.idl             =
SHAREDLIB_PATHS.ld              =       $(PATHS.ld)
SHAREDLIB_FLAGS.cc              =
SHAREDLIB_FLAGS.c               =
SHAREDLIB_FLAGS.antlr.g         =
SHAREDLIB_FLAGS.dlg.g           =
SHAREDLIB_FLAGS.ld              =
SHAREDLIB_LIBS.ld               =
SHAREDLIB_NODEPENDLIBS.ld       =
#************************************************************************
# Fill in the executable parameters here.
#************************************************************************
EXECUTABLE_PATHS.hh             =
EXECUTABLE_PATHS.h              =
EXECUTABLE_PATHS.idl            =
EXECUTABLE_PATHS.ld             =       $(PATHS.ld)
EXECUTABLE_FLAGS.cc             =
EXECUTABLE_FLAGS.c              =
EXECUTABLE_FLAGS.antlr.g        =
EXECUTABLE_FLAGS.dlg.g          =
EXECUTABLE_FLAGS.ld             =
EXECUTABLE_LIBS.ld              =
EXECUTABLE_NODEPENDLIBS.ld     =
#************************************************************************
# Fill in the java parameters here.
#************************************************************************
CLASSES_PATHS.java              =
CLASSES_PATHS.idl               =
CLASSES_FLAGS.java              =
CLASSES_FLAGS.idl               =

#************************************************************************
# Fill in the doc parameters here.
#************************************************************************
DOC_PATH                                = ${MACS_MIRROR}/_${MACS_TARGET}/doc
JAVADOC_DIRS                            = $(SUBDIRS)

#************************************************************************
# Fill in the library schema parameters here.
#************************************************************************
LIBSCHEMA_PATHS.so                      =       $(PATHS.hh)
LIBSCHEMA_FLAGS.so                      =

#************************************************************************
# Fill in the application schema parameters here.
#************************************************************************
APPSCHEMA_PATHS.so                      =       $(PATHS.hh)
APPSCHEMA_FLAGS.so                      =
APPSCHEMA_PATHS.ldb                     =
APPSCHEMA_FLAGS.ldb                     =

#************************************************************************
# Fill in the general test parameters here
#************************************************************************
TEST_PATHS.h                                    =       $(PATHS.h)
TEST_PATHS.hh                                   =       $(PATHS.hh)
TEST_PATHS.java                                 =       $(PATHS.java)
TEST_PATHS.os                                   =       $(PATHS.os)
TEST_PATHS.ld                                   =       $(PATHS.ld)
TEST_FLAGS.cc                                   =       $(FLAGS.cc)
TEST_FLAGS.c                                    =       $(FLAGS.c)
TEST_FLAGS.java                                 =       $(FLAGS.java)
TEST_FLAGS.os                                   =       $(FLAGS.os)
TEST_FLAGS.ld                                   =       $(FLAGS.ld)

#************************************************************************
# Fill in the test archive parameters here.
#************************************************************************
TEST_ARCHIVE_PATHS.hh                   =
TEST_ARCHIVE_PATHS.h                    =
TEST_ARCHIVE_PATHS.ld                   =
TEST_ARCHIVE_FLAGS.cc                   =
TEST_ARCHIVE_FLAGS.c                    =
TEST_ARCHIVE_FLAGS.ld                   =

#************************************************************************
# Fill in the test sharedlib parameters here.
#************************************************************************
TEST_SHAREDLIB_PATHS.hh                 =
TEST_SHAREDLIB_PATHS.h                  =
TEST_SHAREDLIB_PATHS.ld                 =
TEST_SHAREDLIB_FLAGS.cc                 =
TEST_SHAREDLIB_FLAGS.c                  =
TEST_SHAREDLIB_FLAGS.ld                 =
TEST_SHAREDLIB_LIBS.ld                  =
TEST_SHAREDLIB_NODEPENDLIBS.ld  =       $(SHAREDLIB_NODEPENDLIBS.ld)

#************************************************************************
# Fill in the test executable parameters here.
#************************************************************************
TEST_EXECUTABLE_PATHS.hh                =
TEST_EXECUTABLE_PATHS.h                 =
TEST_EXECUTABLE_PATHS.ld                =
TEST_EXECUTABLE_FLAGS.cc                =
TEST_EXECUTABLE_FLAGS.c                 =
TEST_EXECUTABLE_FLAGS.ld                =
TEST_EXECUTABLE_LIBS.ld                 =
TEST_EXECUTABLE_NODEPENDLIBS.ld         =       $(EXECUTABLE_NODEPENDLIBS.ld)

#************************************************************************
# Fill in the test java parameters here.
#************************************************************************
TEST_CLASSES_PATHS.java                 =       $(CLASSES_PATHS.java)
TEST_CLASSES_FLAGS.java                 =       $(CLASSES_FLAGS.java)

#************************************************************************
# Fill in the test application schema parameters here.
#************************************************************************
TEST_APPSCHEMA_PATHS.so                 =       $(APPSCHEMA_PATHS.so)
TEST_APPSCHEMA_FLAGS.so                 =       $(APPSCHEMA_FLAGS.so)
TEST_APPSCHEMA_PATHS.ldb                =       $(APPSCHEMA_PATHS.ldb)
TEST_APPSCHEMA_FLAGS.ldb                =       $(APPSCHEMA_FLAGS.ldb)


#*************************************************************************


# Java section.
JAVA_HOME               = $(JAVAHOME)
ANT_HOME                = $(ANTHOME)
ANT             = $(ANTHOME)/bin/ant
JUNIT_HOME      = $(JUNITHOME)
VISIBROKER_HOME = $(VISIBROKERHOME)
ORACLE_HOME     = $(ORACLEHOME)
AXIS_HOME               = $(AXISHOME)
JCORE_HOME              = $(FDSJCOREHOME)
JGENERAL_HOME           = $(FDSJGENERALHOME)
JDBINTERFACE_HOME       = $(FDSJDBINTERFACEHOME)
JEVENTSENDER_HOME       = $(FDSJEVENTSENDERHOME)
JPROCLOGSENDER_HOME     = $(FDSJPROCLOGSENDERHOME)
XERCESJ_HOME            = $(XERCES-JHOME)

export JAVA_HOME
export ANT_HOME
export JUNIT_HOME
export VISIBROKER_HOME
export ORACLE_HOME
export AXIS_HOME
export JCORE_HOME
export JDBINTERFACE_HOME
export JGENERAL_HOME
export JEVENTSENDER_HOME
export JPROCLOGSENDER_HOME
export XERCESJ_HOME
ifeq ($(TEST), TRUE)
        export UNIT_TEST=TRUE
endif

#************************************************************************
endif
LOCAL_CONFIG = FALSE
# **********************************************************************
# REVISION HISTORY
#
#  $Log$
# **********************************************************************
