SUMMARY = "Diary configuration: motd and version stamp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://motd"
S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/motd ${D}${sysconfdir}/motd
    date > ${D}${sysconfdir}/diary-version
    chmod 0644 ${D}${sysconfdir}/diary-version
}
CONFFILE:${PN} = "{sysconfdir}/motd"
FILES:${PN} = "${sysconfdir}/motd ${sysconfdir}/diary-version"


