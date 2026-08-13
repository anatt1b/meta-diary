# Do not ship /etc/motd from base-files; diary-config provides it instead.
do_install:append() {
    rm -f ${D}${sysconfdir}/motd
    sed -i 's|/dev/sda|/dev/vda|g' ${D}${sysconfdir}/fstab
}
