import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import toast, { Toaster } from "react-hot-toast";
import AmenityService from "../../services/AmenityService";

const UpdateAmenity = () => {
   const navigate = useNavigate();
   const params = useParams();
   const { id } = params;

   const [amenityName, setAmenityName] = useState("");
   const [amenityPrice, setAmenityPrice] = useState("");
   const [description, setDescription] = useState("");
   const [status, setStatus] = useState("");

   const [error, setError] = useState(null);
   const [isModalOpen, setIsModalOpen] = useState(false);

   const toggleModal = () => {
     setIsModalOpen(!isModalOpen);
   };

   const handleSubmit = (e) => {
       e.preventDefault();
       e.stopPropagation();

       const currentAmenity = {
         amenityName,
         amenityPrice,
         description,
         status,
       };

       AmenityService.updateCurrentAmenity(currentAmenity, id)
         .then(() => {
           navigate("/amenities");
           toast.success("Update Amenity Complete!");
           setIsModalOpen(false);
           window.location.reload();
         })
         .catch((error) => {
           setError(error.message);
           console.error(error);
         });
    };

    useEffect(() => {
      const fetchCurrentAmenity = async () => {
        try {
          const response = await AmenityService.getAmenityById(id);
          const update = response.data;

          setAmenityName(update.amenityName);
          setAmenityPrice(update.amenityPrice);
          setDescription(update.description);
          setStatus(update.status);
        } catch (error) {
          console.error(error);
        }
      };

      fetchCurrentAmenity();
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
                htmlFor="amenityName"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Amenity Name
              </label>
              <input
                type="text"
                id="amenityName"
                value={amenityName}
                onChange={(e) => setAmenityName(e.target.value)}
                className="form-input"
              />
            </div>

            <div className="sm:col-span-1">
              <label
                htmlFor="amenityPrice"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Amenity Price
              </label>
              <input
                type="text"
                id="amenityPrice"
                value={amenityPrice}
                onChange={(e) => setAmenityPrice(e.target.value)}
                className="form-input"
              />
            </div>

            <div className="sm:col-span-1">
              <label
                htmlFor="description"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Description
              </label>
              <input
                type="text"
                id="description"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                className="form-input"
              />
            </div>

            <div className="sm:col-span-1">
              <label
                htmlFor="status"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Status
              </label>
              <input
                type="text"
                id="status"
                value={status}
                onChange={(e) => setStatus(e.target.value)}
                className="form-input"
              />
            </div>

            <div className="sm:col-span-1">
              <button
                type="submit"
                className="btn w-full py-2 px-4 text-lg bg-warning border border-warning rounded-md text-black transition-all duration-300 hover:bg-warning/[0.85] hover:border-warning/[0.85]"
              >
                Update Amenity
              </button>
            </div>
          </form>
        </div>
      </div>
    </>
  );
}

export default UpdateAmenity