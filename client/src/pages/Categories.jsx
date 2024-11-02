import React, { useState, useEffect } from "react";
import Modal from "../layout/Modal";
import { createPortal } from "react-dom";
import { Toaster } from "react-hot-toast";
import { Link } from "react-router-dom";
import CategoryService from "../services/CategoryService";


const Categories = () => {

  const [categories, setCategories] = useState([]);
  const [isModalOpen, setIsModalOpen] = useState(false);

  const toggleModal = () => {
    setIsModalOpen(!isModalOpen);
  };

  useEffect(() => {
    const fetchCategories = async () => {
      const response = await CategoryService.getAllCategories();
      setCategories(response.data);
    };
    fetchCategories();
  }, []);


  return <div>Categories</div>;
};

export default Categories;
