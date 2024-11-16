export const useUserService = () => {
    const getUser = async (params={}) => {
      try {
        const { data, error } = await useFetch('http://localhost:8080/user', {params})
        if (error.value) {
          throw new Error('Erro ao buscar os dados do usuário')
        }
        return data.value
      } catch (err) {
        console.error('Erro ao chamar o endpoint de usuário', err)
        return null
      }
    }
    const createUser = async (item, params={}) => {
      try {
        const { data, error } = await useFetch('http://localhost:8080/user', 
          {
            method: 'POST', 
            body: item, 
            params
          }
        )
        if (error.value) {
          throw new Error('Erro ao buscar os dados do usuário')
        }
        return data.value
      } catch (err) {
        console.error('Erro ao chamar o endpoint de usuário', err)
        return null
      }
    }
    const updateUser = async (userId: number, item, params={}) => {
      try {
        const { data, error } = await useFetch(`http://localhost:8080/user/${userId}`, 
          {
            method: 'PUT', 
            body: item, 
            params
          }
        )
        if (error.value) {
          throw new Error('Erro ao buscar os dados do usuário')
        }
        return data.value
      } catch (err) {
        console.error('Erro ao chamar o endpoint de usuário', err)
        return null
      }
    }

  
    return {
      getUser,
      createUser,
      updateUser
    }
  }
  