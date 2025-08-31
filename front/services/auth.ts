const { post } = useApi()

export interface LoginParams {
  email: string
  password: string
}

export interface RegisterParams {
  name: string
  email: string
  password: string
}
export const useAuthService = () => {
  const login = async (params: LoginParams) => {
    return await post('/auth/login', params)
  }
  const register = async (item: RegisterParams) => {
    return await post('/auth/register', item)
  }

  return {
    login,
    register,
  }
}
