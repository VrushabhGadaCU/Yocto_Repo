SUMMARY = "Network configuration for WiFi and Ethernet priority"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://wlan0.network \
           file://eth0.network \
          "

S = "${WORKDIR}"

do_install() {
    # Install systemd network files
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/wlan0.network ${D}${sysconfdir}/systemd/network/20-wlan0.network
    install -m 0644 ${WORKDIR}/eth0.network ${D}${sysconfdir}/systemd/network/10-eth0.network
}

FILES:${PN} += "${sysconfdir}/systemd/network/*"
