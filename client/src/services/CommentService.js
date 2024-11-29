import axios from "axios";

const API_BASE_URL = import.meta.env.VITE_BASE_URI_BOOKINGS;

const CommentService = {
  addNewComment(bookingId, commentData) {
    return axios.post(`${API_BASE_URL}/${bookingId}/comments`, commentData);
  },

  getAllComments(bookingId) {
    return axios.get(`${API_BASE_URL}/${bookingId}/comments`);
  },

  getCommentById(commentId) {
    return axios.get(`${API_BASE_URL}/comments/${commentId}`);
  },

  getCommentsByBookingId(bookingId) {
    return axios.get(`${API_BASE_URL}/${bookingId}/comments`);
  },

  deleteComment(commentId) {
    return axios.delete(`${API_BASE_URL}/comments/${commentId}`);
  },

};

export default CommentService