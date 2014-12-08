#!/bin/bash

basedir=/d/umobile/ema/zhlr_jl
deploydir=/var/sog/sdk/downstream/java/ZHLR

cd $basedir 		|| { echo "ERROR: Can't chdir to $basedir/" >&2; exit 1; }
/usr/local/ant/bin/ant	|| { echo "ERROR: Ant build failed" >&2; exit 1; }

echo
echo "Transfering the jar file to EMA:$deploydir/ ..."

scp dist/HlrJavaLink.jar root@ema:/var/sog/sdk/downstream/java/ZHLR/ || {
    echo "ERROR: File transfer failed" >&2; exit 1;
}

echo
echo "DONE."
