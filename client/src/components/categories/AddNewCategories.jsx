import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import toast, { Toaster } from "react-hot-toast";
import moment from "moment";
import CategoriesService from "../../services/CategoriesService";

const AddNewCategories = () => {

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

   const handleSubmit = async (e) => {
     e.preventDefault();

     const newCategory = {
       name,
       description,
     };

     CategoriesService.addNewCategory(newCategory)
       .then(() => {
         navigate("/categories");
         toast.success("New Category added successfully!");
       })
       .catch((error) => {
         setError(error.response.data.message);
       });
   };

  
  return <div>AddNewCategories</div>;
};

export default AddNewCategories;
