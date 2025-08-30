export const useApi = () => {
  const config = useRuntimeConfig()

  const request = async <T>(
    url: string,
    options: {
      method?: 'GET' | 'POST' | 'PUT' | 'DELETE',
      body?: any,
      params?: Record<string, any>
    } = {}
  ): Promise<T | null> => {
    try {
      const { data, error } = await useFetch<T>(`${config.public.baseUrl}${url}`, {
        method: options.method || 'GET',
        body: options.body,
        params: options.params,
      })

      if (error.value) {
        throw new Error(error.value.message || 'Erro na requisição')
      }

      return data.value as T
    } catch (err) {
      console.error('Erro na API:', err)
      return null
    }
  }

  const get = <T>(url: string, params?: Record<string, any>) =>
    request<T>(url, { method: 'GET', params })

  const post = <T>(url: string, body?: any, params?: Record<string, any>) =>
    request<T>(url, { method: 'POST', body, params })

  const put = <T>(url: string, body?: any, params?: Record<string, any>) =>
    request<T>(url, { method: 'PUT', body, params })

  const del = <T>(url: string, params?: Record<string, any>) =>
    request<T>(url, { method: 'DELETE', params })

  return { get, post, put, del }
}
