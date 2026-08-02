SUMMARY = "Custom image for the custom-linux course diary"
LICENSE = "MIT"

IMAGE_FEATURES += "ssh-server-openssh package-management"

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    kernel-modules \
    vim nano htop less curl \
    sl \
    diary-config \
    sudo \
    "

inherit core-image
inherit extrausers

IMAGE_ROOTFS_EXTRA_SPACE = "65536"

EXTRA_USERS_PARAMS = "\
    useradd -p '\$6\$/Nlf64Q5m36bbhJK\$vM1m4c0adwwR1/OMC6Vly6O7p91XeEZCOecfs5.90SCG0fOIJ.vinV7pfu2IxIkFKh0QHLEjlBWfvQV73AWyz.' student; \
    usermod -a -G sudo student; \
    "
IMAGE_INSTALL += "diary-char"
