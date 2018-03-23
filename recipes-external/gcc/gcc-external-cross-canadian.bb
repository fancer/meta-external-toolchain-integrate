require recipes-external/gcc/gcc-external.inc
inherit external-toolchain-cross-canadian

PN .= "-${TRANSLATED_TARGET_ARCH}"

RDEPENDS_${PN} = "binutils-external-cross-canadian-${TRANSLATED_TARGET_ARCH}"
FILES_${PN} = "\
    ${libdir}/gcc/${EXTERNAL_TARGET_SYS} \
    ${libexecdir}/gcc/${EXTERNAL_TARGET_SYS} \
    ${@'${gcc_binaries}'.replace('${TARGET_PREFIX}', '${bindir}/${EXTERNAL_TARGET_SYS}-')} \
"

INSANE_SKIP_${PN} += "dev-so staticdev"
