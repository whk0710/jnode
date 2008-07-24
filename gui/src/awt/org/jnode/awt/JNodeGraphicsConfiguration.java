/*
 * $Id$
 *
 * JNode.org
 * Copyright (C) 2003-2006 JNode.org
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; If not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package org.jnode.awt;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.VolatileImage;
import org.jnode.driver.video.FrameBufferConfiguration;

/**
 * @author Ewout Prangsma (epr@users.sourceforge.net)
 */
public class JNodeGraphicsConfiguration extends GraphicsConfiguration {

    private final JNodeFrameBufferDevice device;
    private final Rectangle bounds;
    private final ColorModel colorModel;
    private final FrameBufferConfiguration config;

    public JNodeGraphicsConfiguration(JNodeFrameBufferDevice device, FrameBufferConfiguration config) {
        this.device = device;
        this.bounds = new Rectangle(config.getScreenWidth(), config.getScreenHeight());
        this.colorModel = config.getColorModel();
        this.config = config;
    }

    /**
     * @param w
     * @param h
     * @param transparency
     * @return The image
     * @see java.awt.GraphicsConfiguration#createCompatibleImage(int, int, int)
     */
    public BufferedImage createCompatibleImage(int w, int h, int transparency) {
        return config.createCompatibleImage(w, h, transparency);
    }

    /**
     * @param w
     * @param h
     * @return The image
     * @see java.awt.GraphicsConfiguration#createCompatibleImage(int, int)
     */
    public BufferedImage createCompatibleImage(int w, int h) {
        return createCompatibleImage(w, h, config.getColorModel().getTransparency());
    }

    /**
     * @param w
     * @param h
     * @return The image
     * @see java.awt.GraphicsConfiguration#createCompatibleVolatileImage(int, int)
     */
    public VolatileImage createCompatibleVolatileImage(int w, int h) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return The bounds
     * @see java.awt.GraphicsConfiguration#getBounds()
     */
    public Rectangle getBounds() {
        return (Rectangle) bounds.clone();
    }

    /**
     * @return The color model
     * @see java.awt.GraphicsConfiguration#getColorModel()
     */
    public ColorModel getColorModel() {
        return colorModel;
    }

    /**
     * @param transparency
     * @return The color model
     * @see java.awt.GraphicsConfiguration#getColorModel(int)
     */
    public ColorModel getColorModel(int transparency) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return The default transform
     * @see java.awt.GraphicsConfiguration#getDefaultTransform()
     */
    public AffineTransform getDefaultTransform() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return The device
     * @see java.awt.GraphicsConfiguration#getDevice()
     */
    public GraphicsDevice getDevice() {
        return device;
    }

    /**
     * @return The transform
     * @see java.awt.GraphicsConfiguration#getNormalizingTransform()
     */
    public AffineTransform getNormalizingTransform() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return The framebuffer configuration which is wrapped in this GraphicsConfiguration.
     */
    public FrameBufferConfiguration getConfig() {
        return this.config;
    }

    public String toString() {
        return bounds.width + "x" + bounds.height + "/" + colorModel.getPixelSize();
    }

    @Override
    public VolatileImage createCompatibleVolatileImage(int width, int height, int transparency) {
        // TODO Auto-generated method stub
        return null;
    }
}
