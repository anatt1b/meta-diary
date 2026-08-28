SUMMARY = "Writable tmpfs overlay on /etc for read-only rootfs (stateless demo)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://etc-overlay.service"

S = "${WORKDIR}"

inherit systemd
SYSTEMD_SERVICE:${PN} = "etc-overlay.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/etc-overlay.service ${D}${systemd_system_unitdir}/etc-overlay.service
}

FILES:${PN} = "${systemd_system_unitdir}/etc-overlay.service"
