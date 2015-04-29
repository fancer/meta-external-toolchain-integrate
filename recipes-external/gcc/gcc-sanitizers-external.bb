GCC_VERSION := "${@external_run(d, 'gcc', '-dumpversion').rstrip()}"
PV = "${GCC_VERSION}"
BINV = "${GCC_VERSION}"

require recipes-devtools/gcc/gcc-sanitizers.inc
inherit external-toolchain

# Undo various bits we don't want from the upstream include
EXTRA_OECONF = ""
BBCLASSEXTEND = ""

python () {
    lic_deps = d.getVarFlag('do_populate_lic', 'depends', True).split()
    d.setVarFlag('do_populate_lic', 'depends', ' '.join(filter(lambda d: d != 'gcc-source:do_unpack', lic_deps)))

    cfg_deps = d.getVarFlag('do_configure', 'depends', True).split()
    d.setVarFlag('do_configure', 'depends', ' '.join(filter(lambda d: d != 'gcc-source:do_preconfigure', cfg_deps)))
}
