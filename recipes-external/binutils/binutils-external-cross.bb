require recipes-external/binutils/binutils-external.inc
inherit external-toolchain-cross

PN .= "-${TARGET_ARCH}"
PROVIDES += "virtual/${TARGET_PREFIX}binutils"

EXTERNAL_CROSS_BINARIES = "${@' '.join('${TARGET_PREFIX}' + i for i in '${binutils_binaries}'.split())}"

do_install_append () {
    if [ ! -e ${D}${bindir}/${TARGET_PREFIX}ld.bfd ]; then
        ln -s ${TARGET_PREFIX}ld ${D}${bindir}/${TARGET_PREFIX}ld.bfd
    fi
}
