import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import toast, { Toaster } from "react-hot-toast";
import CategoryService from "../../services/CategoryService";

const UpdateCategory = () => {
  
      const navigate = useNavigate();
      const params = useParams();
      const { id } = params;

      const [categoryName, setCategoryName] = useState("");
      const [description, setDescription] = useState("");

      const [error, setError] = useState(null);
      const [isModalOpen, setIsModalOpen] = useState(false);

      const toggleModal = () => {
        setIsModalOpen(!isModalOpen);
      };

       const handleSubmit = (e) => {
         e.preventDefault();
         e.stopPropagation();

         const currentCategory = {
           categoryName,
           description,
         };

         CategoryService.updateCurrentCategory(currentCategory, id)
           .then(() => {
             navigate("/categories");
             toast.success("Update Category Complete!");
             setIsModalOpen(false);
             window.location.reload();
           })
           .catch((error) => {
             setError(error.message);
             console.error(error);
           });
       };

       useEffect(() => {
         const fetchCurrentCategory = async () => {
           try {
             const response = await CategoryService.getCategoryById(id);
             const update = response.data;

             setCategoryName(update.categoryName);
             setDescription(update.description);
             
           } catch (error) {
             setError(error.message);
             console.error(error);
           }
         };
         fetchCurrentCategory();
       }, [id]);

      
  return (
    <>
      <div className="grid grid-cols-1 gap-4 md:grid-cols-1">
        <div className="p-5 bg-white border rounded border-black/10 dark:bg-darklight dark:border-darkborder">
          <form
            onSubmit={handleSubmit}
            onClick={(e) => e.stopPropagation()}
            className="grid grid-cols-1 sm:grid-cols-2 gap-4"
          >
            <div className="sm:col-span-1">
              <label
                htmlFor="categoryName"
                className="block text-sm font-medium text-gray-900"
              >
                Category Name:
              </label>
              <input
                placeholder="Category Name"
                required
                type="text"
                className="form-input"
                id="categoryName"
                value={categoryName}
                onChange={(e) => setCategoryName(e.target.value)}
              />
            </div>

            <div className="sm:col-span-1">
              <label
                htmlFor="description"
                className="block text-sm font-medium text-gray-900"
              >
                Category Details:
              </label>
              <textarea
                placeholder="Enter Category Details"
                required
                type="text"
                className="form-input"
                id="description"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                style={{ height: "100px" }}
              />
            </div>
            <div className="sm:col-span-1">
              <button
                type="submit"
                className="btn w-full py-2 px-4 text-lg bg-warning border border-warning rounded-md text-black transition-all duration-300 hover:bg-warning/[0.85] hover:border-warning/[0.85]"
              >
                Update Category
              </button>
            </div>
          </form>
        </div>
      </div>
    </>
  );
}

export default UpdateCategory