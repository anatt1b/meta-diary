SUMMARY = "Diary configuration: motd, version stamp, sudo group, and heartbeat service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://motd \
           file://heartbeat.sh \
           file://heartbeat.service"

S = "${WORKDIR}"

RDEPENDS:${PN} = "sudo"

inherit systemd

SYSTEMD_SERVICE:${PN} = "heartbeat.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/motd ${D}${sysconfdir}/motd
    date > ${D}${sysconfdir}/diary-version
    chmod 0644 ${D}${sysconfdir}/diary-version

    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/heartbeat.sh ${D}${bindir}/heartbeat.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/heartbeat.service ${D}${systemd_system_unitdir}/heartbeat.service

    install -d -m 0750 ${D}${sysconfdir}/sudoers.d
    echo '%sudo ALL=(ALL:ALL) ALL' > ${D}${sysconfdir}/sudoers.d/sudo-group
    chmod 0440 ${D}${sysconfdir}/sudoers.d/sudo-group
}


CONFFILES:${PN} = "${sysconfdir}/motd"
FILES:${PN} = "${sysconfdir}/motd \
               ${sysconfdir}/diary-version \
               ${bindir}/heartbeat.sh \
               ${systemd_system_unitdir}/heartbeat.service \
	       ${sysconfdir}/sudoers.d/sudo-group"
