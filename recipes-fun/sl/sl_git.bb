SUMMARY = "Steam locomotive - runs across the terminal when you mistype 'ls'"
LICENSE = "sl"
LIC_FILES_CHKSUM = "file://LICENSE;md5=74e9dd589a0ab212a9002b15ef2b82f0"

# Kerro Yocolle: lisenssi 'sl' ei ole standardilistalla,
# käytä lähdekoodin LICENSE-tiedostoa lisenssitekstin lähteenä
NO_GENERIC_LICENSE[sl] = "LICENSE"

SRC_URI = "git://github.com/eyJhb/sl;protocol=https;branch=master"
SRCREV = "e419525050ef3fa684c62cf98b89d29cc2adf84d"
PV = "5.04+git"

S = "${WORKDIR}/git"

# ncurses on build-time riippuvuus: sl.c linkittää -lncurses:iin
DEPENDS = "ncurses"

do_compile() {
    oe_runmake 'CC=${CC}' 'CFLAGS=${CFLAGS} ${LDFLAGS}'
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 sl ${D}${bindir}/sl
    install -d ${D}${mandir}/man1
    install -m 0644 sl.1 ${D}${mandir}/man1/sl.1
}
