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

  return (
    <>
         <div className="flex flex-col gap-4 min-h-[calc(100vh-212px)]">
            <div className="grid grid-cols-1 gap-4">
                <div className="p-5 bg-white border rounded border-black/10 dark:bg-darklight dark:border-darkborder">
                </div>
            </div>
        </div>      
    </>
  );
};

export default Categories;
