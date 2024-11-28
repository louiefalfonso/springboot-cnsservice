import axios from "axios";

const API_BASE_URL = import.meta.env.VITE_BASE_URI_BOOKINGS;

const CommentService = {

  addNewComment(bookingId, commentData) {
    return axios.post(`${API_BASE_URL}/${bookingId}/comments`, commentData);
  },

  getAllComments(bookingId) {
    return axios.get(`${API_BASE_URL}/${bookingId}/comments`);
  },  


  getCommentsByBookingId(bookingId) {
    return axios.get(`${API_BASE_URL}/${bookingId}/comments`);
  },

  deleteComment(commentId) {
    return axios.delete(`${API_BASE_URL}/comments/${commentId}`);
  },

  getCommentById(commentId) {
    return axios.get(`${API_BASE_URL}/comments/${commentId}`);
  },



  /*

   addNewComment(id) {
    return axios.post(`${API_BASE_URL}/${id}/comments`, id);
  },

  getAllComments(id) {
    return axios.get(`${API_BASE_URL}/${id}/comments`, id);
  },

  getCommentsByBookingId(id) {
    return axios.get(`${API_BASE_URL}/${id}/comments`);
  },

  deleteComment(id) {
    return axios.delete(`${API_BASE_URL}/${id}/comments`);
  }
    */
};

export default CommentService