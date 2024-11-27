import axios from "axios";

const API_BASE_URL = import.meta.env.VITE_BASE_URI_BOOKINGS;


const CommentService = {
    
  addNewComment(id) {
    return axios.post(`${API_BASE_URL}/${id}/comments`, id);
  },

  getAllComments(id) {
    return axios.get(`${API_BASE_URL}/${id}/comments`, id);
  },

  getCommentsById(id) {
    return axios.get(`${API_BASE_URL}/${id}/comments`);
  },

  deleteComment(id) {
    return axios.delete(`${API_BASE_URL}/${id}/comments`);
  }
  
};

export default CommentService