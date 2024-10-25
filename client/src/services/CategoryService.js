import axios from "axios";

const API_BASE_URL = import.meta.env.VITE_BASE_URI_CATEGORIES;

const CategoryService = {
  addNewCategory(id) {
    return axios.post(API_BASE_URL, id);
  },

  getAllCategories: async () => {
    return axios.get(API_BASE_URL);
  },

  getCategoryById(id) {
    return axios.get(`${API_BASE_URL}/${id}`);
  },

  updateCurrentCategory(currentCategory, id) {
    return axios.put(`${API_BASE_URL}/${id}`, currentCategory);
  },

  deleteCategory(id) {
    return axios.delete(`${API_BASE_URL}/${id}`);
  }

};

export default CategoryService