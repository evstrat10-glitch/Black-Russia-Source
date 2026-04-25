#pragma once

struct SMDFile;

class CCheckFileHash
{
public:
    static bool IsFileValid(SMDFile* pMDFile);
    static bool IsFilesValid();
};
