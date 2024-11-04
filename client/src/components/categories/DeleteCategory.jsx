import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import toast, { Toaster } from "react-hot-toast";
import CategoryService from "../../services/CategoryService";

const DeleteCategory = () => {

    const { id } = useParams();
    const navigate = useNavigate();
    const [categories, setCategories] = useState([]);

    useEffect(() => {
      const fetchCategories = async () => {
        const response = await CategoryService.getAllCategories();
        setCategories(response.data);
      };
      fetchCategories();
    }, []);


      const deleteCategory = async (id) => {
        try {
          await CategoryService.deleteCategory(id);
          toast.success("Deleted Category Successfully!");
          navigate("/categories");
        } catch (error) {
          console.error(error);
        }
      };

  return (
    <div>DeleteCategory</div>
  )
}

export default DeleteCategory