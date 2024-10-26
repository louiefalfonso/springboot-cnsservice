import axios from "axios";

const API_BASE_URL = import.meta.env.VITE_BASE_URI_AMENITIES;

const AmenityService = {

  addNewAmenity(id) {
    return axios.post(API_BASE_URL, id);
  },

  getAllAmenities: async () => {
    return axios.get(API_BASE_URL);
  },

  getAmenityById(id) {
    return axios.get(`${API_BASE_URL}/${id}`);
  },

  updateCurrentAmenity(currentAmenity, id) {
    return axios.put(`${API_BASE_URL}/${id}`, currentAmenity);
  },

  deleteAmenity(id) {
    return axios.delete(`${API_BASE_URL}/${id}`);
  },
};

export default AmenityService;
