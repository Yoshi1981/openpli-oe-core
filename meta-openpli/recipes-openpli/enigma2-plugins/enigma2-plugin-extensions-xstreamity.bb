SUMMARY = "IPTV Xtream Codes playlists player by KiddaC"
HOMEPAGE = "https://www.linuxsat-support.com"
MAINTAINER = "kiddac"
require conf/license/license-gplv2.inc

RDEPENDS_${PN} = "${PYTHON_VER}-argparse ${PYTHON_VER}-image ${PYTHON_VER}-lzma ${PYTHON_VER}-multiprocessing ${PYTHON_VER}-requests \
                  ${@bb.utils.contains("PYTHON_VER", "python", "${PYTHON_PN}-imaging", "${PYTHON_PN}-pillow", d)} \
"

inherit gitpkgv allarch

SRCREV = "${AUTOREV}"

PV = "2.30+git${SRCPV}"
PKGV = "2.30+git${GITPKGV}"

SRC_URI = "git://github.com/kiddac/XStreamity.git;protocol=https"

S = "${WORKDIR}/git"

FILES_${PN} = " ${libdir}/enigma2/python/Components/Converter/* \
                ${libdir}/enigma2/python/Components/Renderer/* \
                ${libdir}/enigma2/python/Plugins/Extensions/XStreamity/*"

do_patch[noexec] = "1"

do_configure[noexec] = "1"

do_compile[noexec] = "1"

do_install() {
install -d ${D}${libdir}/enigma2/python/Components/Converter
install -d ${D}${libdir}/enigma2/python/Components/Renderer
install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/XStreamity
cp -rf ${S}/XStreamity/usr/lib/enigma2/python/Components/Converter/*.py ${D}${libdir}/enigma2/python/Components/Converter/
cp -rf ${S}/XStreamity/usr/lib/enigma2/python/Components/Renderer/*.py ${D}${libdir}/enigma2/python/Components/Renderer/
cp -rf ${S}/XStreamity/usr/lib/enigma2/python/Plugins/Extensions/XStreamity/* ${D}${libdir}/enigma2/python/Plugins/Extensions/XStreamity/
}

pkg_preinst_${PN}() {
#!/bin/sh
if [ -f "/etc/enigma2/X-Streamity/playlists.json" ]
	then
	rm -f /etc/enigma2/X-Streamity/playlists.json > /dev/null 2>&1
fi

if [ -f "/etc/enigma2/xstreamity/playlists.json" ]
	then
	rm -f /etc/enigma2/xstreamity/playlists.json > /dev/null 2>&1
fi

if [ -f "/etc/enigma2/xstreamity/x-playlists.json" ]
	then
	rm -f /etc/enigma2/xstreamity/x-playlists.json > /dev/null 2>&1
fi
}
