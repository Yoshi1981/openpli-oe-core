SUMMARY = "LCD4Linux plugin"
AUTHOR = "IHAD joergm6 <joergm6@www.i-have-a-dreambox.com>"
HOMEPAGE = "http://www.i-have-a-dreambox.com/wbb2/thread.php?threadid=165337"
MAINTAINER = "PLi team"
LICENSE = "NPOSL-3.0"
LIC_FILES_CHKSUM = "file://usr/lib/enigma2/python/Plugins/Extensions/LCD4linux/LICENSE;md5=a06300d1389bd32f84faeb97b6f6771f"

PKGVERSION = "5.0-r4"
PV = "${PKGVERSION}-${SRCPV}"
PKGV = "${PKGVERSION}-${GITPKGV}"

SRC_URI = "git://github.com/eriksl/enigma2-plugin-extensions-lcd4linux-ihad-source-copy.git;protocol=https"

RDEPENDS_${PN} += "\
	png-util \
	pydpflib \
	${PYTHON_VER}-codecs \
	${PYTHON_VER}-ctypes \
	${PYTHON_VER}-datetime \
	${PYTHON_VER}-email \
	${PYTHON_VER}-image \
	${@bb.utils.contains("PYTHON_VER", "python", "${PYTHON_VER}-imaging", "${PYTHON_VER}-pillow", d)} \
	${PYTHON_VER}-mutagen \
	${PYTHON_VER}-pyusb \
	${PYTHON_VER}-shell \
	${PYTHON_VER}-simplejson \
	${PYTHON_VER}-subprocess \
	${PYTHON_VER}-textutils \
	${PYTHON_VER}-zlib \
"

S = "${WORKDIR}/git"

inherit gitpkgv pythonnative

do_compile() {
	python2 -m compileall ${S}${libdir}
}

do_install() {
	cp -r --preserve=mode,links "${S}${prefix}" "${D}"
	cp -r --preserve=mode,links "${S}${sysconfdir}" "${D}"
}

FILES_${PN} = "\
	${libdir}/python2.7 \
	${libdir}/python2.7/site-packages \
	${libdir}/enigma2/python/Components/Renderer/PixmapLcd4linux.py* \
	${libdir}/enigma2/python/Plugins/Extensions/LCD4linux \
	${sysconfdir}/enigma2/lcd4config*"

CONFFILES_${PN} = "${sysconfdir}/enigma2/lcd4config"
