FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://diary.cfg \
            file://hyperv.cfg \
            file://9p.cfg \
            file://0001-diary-mark-kernel-banner.patch \
            file://0001-tracing-probes-fix-typo-in-a-log-message.patch \
            file://overlayfs.cfg"
SRC_URI += "file://harden.cfg"
