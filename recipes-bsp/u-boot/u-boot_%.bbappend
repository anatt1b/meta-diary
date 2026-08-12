do_configure:append() {
    echo 'CONFIG_BOOTDELAY=10' >> ${B}/.config
    oe_runmake -C ${S} O=${B} olddefconfig
}
