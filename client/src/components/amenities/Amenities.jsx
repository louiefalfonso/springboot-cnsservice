import React, { useState, useEffect } from "react";
import Modal from "../layout/Modal";
import { createPortal } from "react-dom";
import { Toaster } from "react-hot-toast";
import AmenityService from "../../services/AmenityService";

const Amenities = () => {
  const [amenities, setAmenities] = useState([]);
  const [isModalOpen, setIsModalOpen] = useState(false);

  const toggleModal = () => {
    setIsModalOpen(!isModalOpen);
  };

  useEffect(() => {
    const fetchAmenities = async () => {
      const response = await AmenityService.getAllAmenities();
      setAmenities(response.data);
    };
    fetchAmenities();
  }, []);
  

  return (
    <div>Amenities</div>
  )
}

export default Amenities