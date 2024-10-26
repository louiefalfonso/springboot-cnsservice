import axios from "axios";

const API_BASE_URL = import.meta.env.VITE_BASE_URI_CUSTOMERS;

const CustomerService = {

  addNewCustomer(id) {
    return axios.post(API_BASE_URL, id);
  },

  getAllCustomers: async () => {
    return axios.get(API_BASE_URL);
  },

  getCustomerById(id) {
    return axios.get(`${API_BASE_URL}/${id}`);
  },

  updateCurrentCustomer(currentCustomer, id) {
    return axios.put(`${API_BASE_URL}/${id}`, currentCustomer);
  },

  deleteCustomer(id) {
    return axios.delete(`${API_BASE_URL}/${id}`);
  },
};

export default CustomerService;
