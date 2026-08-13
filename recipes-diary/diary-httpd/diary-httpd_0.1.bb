SUMMARY = "Simple HTTP service for port forwarding demonstration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://diary-httpd.service \
           file://index.html"

S = "${WORKDIR}"

RDEPENDS:${PN} = "python3-core python3-netclient python3-netserver"

inherit systemd

SYSTEMD_SERVICE:${PN} = "diary-httpd.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    install -d ${D}/srv/www
    install -m 0644 ${WORKDIR}/index.html ${D}/srv/www/index.html

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/diary-httpd.service ${D}${systemd_system_unitdir}/diary-httpd.service
}

FILES:${PN} = "/srv/www \
               ${systemd_system_unitdir}/diary-httpd.service"
