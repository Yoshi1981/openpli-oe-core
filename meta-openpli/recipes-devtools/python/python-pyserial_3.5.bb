SUMMARY = "Serial Port Support for Python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=520e45e59fc2cf94aa53850f46b86436"

SRC_URI[md5sum] = "1cf25a76da59b530dbfc2cf99392dc83"
SRC_URI[sha256sum] = "3c77e014170dfffbd816e6ffc205e9842efb10be9f58ec16d3e8675b4925cddb"

inherit pypi setuptools

PACKAGES =+ "${PN}-java ${PN}-osx ${PN}-win32 ${PN}-tools"

FILES_${PN}-java = " \
    ${PYTHON_SITEPACKAGES_DIR}/serial/*java* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/__pycache__/*java* \
"

FILES_${PN}-osx = " \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/*osx* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/__pycache__/*osx* \
"

FILES_${PN}-win32 = " \
    ${PYTHON_SITEPACKAGES_DIR}/serial/*serialcli* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/__pycache__/*serialcli* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/*win32* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/__pycache__/*win32* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/miniterm* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/__pycache__/miniterm* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/*windows* \
    ${PYTHON_SITEPACKAGES_DIR}/serial/tools/__pycache__/*windows* \
"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-fcntl \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-shell \
    ${PYTHON_PN}-stringold \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-argparse \
"

BBCLASSEXTEND = "native nativesdk"
include python-package-split.inc
