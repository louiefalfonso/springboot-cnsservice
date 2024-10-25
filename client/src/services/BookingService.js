import axios from "axios";

const API_BASE_URL = import.meta.env.VITE_BASE_URI_BOOKINGS;

const BookingService = {

  addNewBooking(id) {
    return axios.post(API_BASE_URL, id);
  },

  getAllBookings: async () => {
    return axios.get(API_BASE_URL);
  },

  getBookingById(id) {
    return axios.get(`${API_BASE_URL}/${id}`);
  },

  updateCurrentBooking(currentBooking, id) {
    return axios.put(`${API_BASE_URL}/${id}`, currentBooking);
  },

  deleteBooking(id) {
    return axios.delete(`${API_BASE_URL}/${id}`);
  },
};

export default BookingService;
