#include "stubs.h"

// Точные имена из ошибок
void RPC_ScrInterpolateCamera() {}
void RPC_ScrAddGangZone() {}
void RPC_ScrRemoveGangZone() {}
void RPC_ScrFlashGangZone() {}
void RPC_ScrStopFlashGangZone() {}
void RPC_ScrCreateObject() {}
void RPC_ScrDestroyObject() {}
void RPC_ScrSetObjectPos() {}
void RPC_ScrPlaySound() {}
void RPC_ScrSetPlayerWantedLevel() {}
void RPC_ScrRemoveComponent() {}
void RPC_ScrSetObjectRotation() {}
void RPC_ClickTextDraw() {}

// RakNet — правильное имя
namespace RAkNet {
    void BitStream::Write1() {}
    void BitStream::Write0() {}
}
