#pragma once

struct SMDFile
{
    char szFileLocation[512];
    unsigned int iCorrectDigestArray[4];
    unsigned char szRawLocalDigest[16];
};
