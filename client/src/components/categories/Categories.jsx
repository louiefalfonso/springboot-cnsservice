import React, { useState, useEffect } from "react";
import Modal from "../layout/Modal";
import { createPortal } from "react-dom";
import { Toaster } from "react-hot-toast";
import CategoryService from "../services/CategoryService";
import AddNewCategories from "./AddNewCategory";
import UpdateCategory from "./UpdateCategory";

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
            <div className="flex items-center justify-between">
              <h2 className="font-bold">Category List</h2>
              <button
                type="button"
                onClick={toggleModal}
                className="btn py-1 px-3.5 text-xs bg-warning border border-warning rounded-md text-black transition-all duration-300 hover:bg-warning/[0.85] hover:border-warning/[0.85]"
              >
                + Add Category
              </button>
            </div>
            <div className="overflow-auto">
              <table className="min-w-[640px] w-full mt-4 table-striped">
                <thead>
                  <tr className="ltr:text-left rtl:text-right">
                    <th>Category Id</th>
                    <th>Category Name</th>
                    <th>Description</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody className="text-center">
                  {categories.map((category, index) => (
                    <tr
                      key={category._id || index}
                      className="ltr:text-left rtl:text-right"
                    >
                      <td>{category.id}</td>
                      <td>{category.name}</td>
                      <td>{category.description}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      {isModalOpen &&
        createPortal(
          <Modal
            isOpen={isModalOpen}
            toggleModal={toggleModal}
            title="Create New Category"
            divClass="flex items-start justify-center min-h-screen px-4"
            content={<AddNewCategories toggleModal={toggleModal} />}
            sizeClass="relative w-full max-w-lg p-0 my-8 overflow-hidden bg-white border rounded-lg border-black/10 dark:bg-darklight dark:border-darkborder"
            spaceClass="p-5 space-y-4"
          />,
          document.body
        )}
      {isModalOpen &&
        createPortal(
          <Modal
            isOpen={isModalOpen}
            toggleModal={toggleModal}
            title="UpdateCategory"
            divClass="flex items-start justify-center min-h-screen px-4"
            content={<UpdateCategory toggleModal={toggleModal} />}
            sizeClass="relative w-full max-w-lg p-0 my-8 overflow-hidden bg-white border rounded-lg border-black/10 dark:bg-darklight dark:border-darkborder"
            spaceClass="p-5 space-y-4"
          />,
          document.body
        )}

      <Toaster duration={12000} />
    </>
  );
};

export default Categories;
