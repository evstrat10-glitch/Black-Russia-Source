#include "stubs.h"

// Заглушки для недостающих RPC-функций
void RPC_ScrInterpolateCamera() {}
void RSC_AddGangZone() {}
void RPC_ScrRemoveGangZone() {}
void RSC_ScrFlashGangZone() {}
void RPC_ScrStopFlashGangZone() {}
void RSC_ScrCreateObject() {}
void RPC_ScrDestroyObject() {}
void RSC_ScrSetObjectPos() {}
void RPC_ScrPlaySound() {}
void RSC_ScrSetPlayerWantedLevel() {}
void RPC_ScrRemoveComponent() {}
void RSC_ScrSetObjectRotation() {}
void RPC_ClickTextDraw() {}

// Заглушки для RakNet
namespace RAKlet {
    void BitStream::Write1() {}
    void BitStream::Write0() {}
}
