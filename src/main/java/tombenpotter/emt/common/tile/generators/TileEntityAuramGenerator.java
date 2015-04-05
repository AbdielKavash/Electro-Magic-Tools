/*******************************************************************************
 * Copyright (c) 2014 Tombenpotter.
 * All rights reserved. 
 *
 * This program and the accompanying materials are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at http://www.gnu.org/licenses/gpl.html
 *
 * This class was made by Tombenpotter and is distributed as a part of the Electro-Magic Tools mod.
 * Electro-Magic Tools is a derivative work on Thaumcraft 4 (c) Azanor 2012.
 * http://www.minecraftforum.net/topic/1585216-
 ******************************************************************************/

package tombenpotter.emt.common.tile.generators;

import thaumcraft.api.aspects.Aspect;
import tombenpotter.emt.common.util.EssentiasOutputs;

public class TileEntityAuramGenerator extends TileEntityBaseGenerator {

    public TileEntityAuramGenerator() {
        aspect = Aspect.AURA;
        EssentiasOutputs.outputs.get(aspect.getTag());
    }
}
