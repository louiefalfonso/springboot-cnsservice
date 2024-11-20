import React, { useState, useEffect } from "react";
import Modal from "../layout/Modal";
import { createPortal } from "react-dom";
import { Toaster } from "react-hot-toast";

import AmenityService from "../../services/AmenityService";
import AddNewAmenity from "./AddNewAmenity";
import UpdateAmenity from "./UpdateAmenity";
import DeleteAmenity from "./DeleteAmenity";

const Amenities = () => {

  const [amenities, setAmenities] = useState([]);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [error, setError] = useState(null);

  const [isDeleteModalOpen, setIsDeleteModalOpen] = useState(false);
  const [isUpdateModalOpen, setIsUpdateModalOpen] = useState(false);

  const toggleModal = () => { setIsModalOpen(!isModalOpen); };
  const toggleDeleteModal = () => { setIsDeleteModalOpen(!isDeleteModalOpen); };
  const toggleUpdateModal = () => { setIsUpdateModalOpen(!isUpdateModalOpen); };

  useEffect(() => {
    const fetchAmenities = async () => {
      const response = await AmenityService.getAllAmenities();
      setAmenities(response.data);
    };
    fetchAmenities();
  }, []);


  return (
    <>
      <div className="flex flex-col gap-4 min-h-[calc(100vh-212px)]">
        <div className="grid grid-cols-1 gap-4">
          <div className="p-5 bg-white border rounded border-black/10 dark:bg-darklight dark:border-darkborder">
            <div className="flex items-center justify-between">
              <h2 className="font-bold">Amenity List</h2>
              <button
                type="button"
                onClick={toggleModal}
                className="btn py-1 px-3.5 text-xs bg-warning border border-warning rounded-md text-black transition-all duration-300 hover:bg-warning/[0.85] hover:border-warning/[0.85]"
              >
                + Add New Amenity
              </button>
            </div>
            <div className="overflow-auto">
              <table className="min-w-[640px] w-full mt-4 table-striped">
                <thead>
                  <tr className="ltr:text-left rtl:text-right">
                    <th>Amenity Name</th>
                    <th>Amenity Price</th>
                    <th>Status</th>
                    <th>Description</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody className="text-center">
                  {amenities.map((amenity) => (
                    <tr
                      key={amenity._id}
                      className="ltr:text-left rtl:text-right"
                    >
                      <td>{amenity.amenityName}</td>
                      <td>{amenity.amenityPrice}</td>
                      <td>{amenity.status}</td>
                      <td>{amenity.description}</td>
                      <td>
                        <button
                          type="button"
                          onClick={() => toggleUpdateModal(amenity._id)}
                          className="btn py-1 px-3.5 text-xs bg-warning border border-warning rounded-md text-black transition-all duration-300 hover:bg-warning/[0.85] hover:border-warning/[0.85]"
                        >
                          Update
                        </button>
                        <button
                          type="button"
                          onClick={() => toggleDeleteModal(amenity._id)}
                          className="btn py-1 px-3.5 text-xs bg-danger border border-danger rounded-md text-black transition-all duration-300 hover:bg-danger/[0.85] hover:border-danger/[0.85]"
                        >
                          Delete
                        </button>
                      </td>
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
            title="Create New Amenity"
            divClass="flex items-start justify-center min-h-screen px-4"
            content={<AddNewAmenity toggleModal={toggleModal} />}
            sizeClass="relative w-full max-w-lg p-0 my-8 overflow-hidden bg-white border rounded-lg border-black/10 dark:bg-darklight dark:border-darkborder"
            spaceClass="p-5 space-y-4"
          />,
          document.body
        )}
      {isDeleteModalOpen &&
        createPortal(
          <Modal
            isOpen={isDeleteModalOpen}
            toggleModal={toggleDeleteModal}
            title="Delete Amenity"
            divClass="flex items-center justify-center min-h-screen px-4"
            content={<DeleteAmenity toggleModal={toggleDeleteModal} />}
            sizeClass="relative w-full max-w-lg p-0 my-8 overflow-hidden bg-white border rounded-lg border-black/10 dark:bg-darklight dark:border-darkborder"
            spaceClass="p-5 space-y-4"
          />,
          document.body
        )}
      {isUpdateModalOpen &&
        createPortal(
          <Modal
            isOpen={isUpdateModalOpen}
            toggleModal={toggleUpdateModal}
            title="Update Amenity"
            divClass="flex items-center justify-center min-h-screen px-4"
            content={<UpdateAmenity toggleModal={toggleUpdateModal} />}
            sizeClass="relative w-full max-w-lg p-0 my-8 overflow-hidden bg-white border rounded-lg border-black/10 dark:bg-darklight dark:border-darkborder"
            spaceClass="p-5 space-y-4"
          />,
          document.body
        )}
      <Toaster duration={12000} />
    </>
  );
}

export default Amenities