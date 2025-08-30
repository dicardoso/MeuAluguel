const { get, post, put } = useApi()

export const useUserService = () => {
    const getUser = async (params = {}) => {
      return await get('/user', params)
    }
    const createUser = async (item: any, params = {}) => {
      return await post('/user', item, params)
    }
    const updateUser = async (userId: number, item: any, params = {}) => {
      return await put(`/user/${userId}`, item, params)
    }
    
    return {
      getUser,
      createUser,
      updateUser
    }
  }
  