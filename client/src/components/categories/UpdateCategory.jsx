import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import toast, { Toaster } from "react-hot-toast";
import CategoryService from "../../services/CategoryService";

const UpdateCategory = () => {
      const navigate = useNavigate();
      const params = useParams();
      const { id } = params;

      const [categoryId, setCategoryId] = useState("");
      const [categoryName, setCategoryName] = useState("");
      const [description, setDescription] = useState("");

      const [error, setError] = useState(null);
      const [isModalOpen, setIsModalOpen] = useState(false);

      const toggleModal = () => {
        setIsModalOpen(!isModalOpen);
      };

      
  return (
    <div>UpdateCategory</div>
  )
}

export default UpdateCategory