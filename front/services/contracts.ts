const { get, post, put } = useApi()

export const useContractService = () => {
    const getContract = async (params = {}) => {
      return await get('/contract', params)
    }
    const generateContract = async (params = {}) => {
      return await get('/contract', params)
    }
    const createContract = async (item: any, params = {}) => {
      return await post('/contract', item, params)
    }
    const cancelContract = async (params = {}) => {
      return await post('/contract/cancel', params)
    }
    const updateContract = async (userId: number, item: any, params = {}) => {
      return await put(`/contract/${userId}`, item, params)
    }
    
    return {
      getContract,
      createContract,
      updateContract,
      generateContract,
      cancelContract
    }
  }
  