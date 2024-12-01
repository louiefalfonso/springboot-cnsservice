import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import toast, { Toaster } from "react-hot-toast";
import CommentService from "../../services/CommentService";

const UpdateComment = () => {

  const navigate = useNavigate();
  const params = useParams();
  const { id } = params;

  const [commentId, setCommentId] = useState("");
  const [bookingId, setBookingId] = useState("");
  const [commentName, setCommentName] = useState("");
  const [commentEmail, setCommentEmail] = useState("");
  const [commentBody, setCommentBody] = useState("");

  const [error, setError] = useState(null);
  const [isModalOpen, setIsModalOpen] = useState(false);

  const toggleModal = () => {
    setIsModalOpen(!isModalOpen);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    e.stopPropagation();

    const currentComment = {
      commentName,
      commentEmail,
      commentBody,
    };

    CommentService.updateComment(id, currentComment)
      .then((response) => {
        navigate("/bookings");
      })
      .catch((error) => {
        setError(error);
      });
  };

  useEffect(() => {
    const fetchCurrentComment = async () => {
      try {
        const response = await CommentService.getCommentsById(id);
        const update = response.data;
        
        setCommentName(update.commentName);
        setCommentEmail(update.commentEmail);
        setCommentBody(update.commentBody);

      } catch (error) {
        setError(error);
      }
    };  
    fetchCurrentComment();
  }, [id]);


  return (
    <>UpdateComment</>
  )
}

export default UpdateComment