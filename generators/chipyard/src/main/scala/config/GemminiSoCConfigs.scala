package chipyard

import freechips.rocketchip.config.{Config}

class CustomGemminiSoCConfig extends Config(
  new gemmini.GemminiCustomConfig ++

  // Set your custom L2 configs
  new freechips.rocketchip.subsystem.WithInclusiveCache(
    nBanks = 1,
    nWays = 8,
    capacityKB = 512,
    outerLatencyCycles = 40
  ) ++

  // Set the number of CPUs you want to create
  new chipyard.CustomGemmminiCPUConfigs.CustomCPU(1) ++

  new chipyard.config.AbstractConfig
)

/*************************************************/
//Top DSE Config
//
//***********************************************/
class MyDSECustomGemminiSoCConfig extends Config(
  // new gemmini.GemminiCustomConfig ++
  new gemmini.GemminiParamsDSE5 ++
  // Set your custom L2 configs
  new freechips.rocketchip.subsystem.WithInclusiveCache(
    nBanks = 1,
    nWays = 8,
    capacityKB = 512,
    outerLatencyCycles = 40
  ) ++

  // Set the number of CPUs you want to create
  // new chipyard.CustomGemmminiCPUConfigs.BoomLargeCores(1) ++ //CustomCPU(1) ++LargeCores

  new chipyard.CustomGemmminiCPUConfigs.CustomCPU(1) ++

  new chipyard.config.AbstractConfig
)



