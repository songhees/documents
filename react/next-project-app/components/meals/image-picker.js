'use client';

import { useRef, useState } from 'react';
import classes from './image-picker.module.css'
import Image from 'next/image';

export default function ImagePicker({label, name}) {
    const [pickedImage, setPickImage] = useState();
    const imageInputRef = useRef();

    function handlePickClick() {
        imageInputRef.current.click();
    } 

    function handleImageChage(event) {
        const file = event.target.files[0];
        if (!file) {
            setPickImage(null);
            return;
        }

        const fileReader = new FileReader();
        fileReader.onload = () => {
            setPickImage(fileReader.result);
        }
        fileReader.readAsDataURL(file);
        
    }

    return (
        <div className={classes.picker}>
            <label htmlFor={name}>
                {label}
            </label>
            <div className={classes.controls}>
                <div className={classes.preview}>
                    {!pickedImage && <p>No Image picked yet.</p>}
                    {pickedImage && <Image src={pickedImage} fill alt="The image selected by the user."/>}
                </div>
                <input 
                    className={classes.input}
                    type='file' 
                    id={name} 
                    accept='image/png, image/jpeg' 
                    name={name}
                    ref={imageInputRef}
                    onChange={handleImageChage}
                    required
                />
                <button className={classes.button} type='button' onClick={handlePickClick}>
                    Pick an Image
                </button>
            </div>
        </div>
    )
}