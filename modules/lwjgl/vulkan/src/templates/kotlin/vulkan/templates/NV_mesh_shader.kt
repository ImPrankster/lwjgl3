/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package vulkan.templates

import org.lwjgl.generator.*
import vulkan.*

val NV_mesh_shader = "NVMeshShader".nativeClassVK("NV_mesh_shader", type = "device", postfix = NV) {
    documentation =
        """
        This extension provides a new mechanism allowing applications to generate collections of geometric primitives via programmable mesh shading. It is an alternative to the existing programmable primitive shading pipeline, which relied on generating input primitives by a fixed function assembler as well as fixed function vertex fetch.

        There are new programmable shader types -- the task and mesh shader -- to generate these collections to be processed by fixed-function primitive assembly and rasterization logic. When the task and mesh shaders are dispatched, they replace the standard programmable vertex processing pipeline, including vertex array attribute fetching, vertex shader processing, tessellation, and the geometry shader processing.

        This extension also adds support for the following SPIR-V extension in Vulkan:  * SPV_NV_mesh_shader

        <dl>
            <dt><b>Name String</b></dt>
            <dd>{@code VK_NV_mesh_shader}</dd>

            <dt><b>Extension Type</b></dt>
            <dd>Device extension</dd>

            <dt><b>Registered Extension Number</b></dt>
            <dd>203</dd>

            <dt><b>Revision</b></dt>
            <dd>1</dd>

            <dt><b>Extension and Version Dependencies</b></dt>
            <dd><ul>
                <li>Requires Vulkan 1.0</li>
                <li>Requires {@link KHRGetPhysicalDeviceProperties2 VK_KHR_get_physical_device_properties2}</li>
            </ul></dd>

            <dt><b>Contact</b></dt>
            <dd><ul>
                <li>Christoph Kubisch <a target="_blank" href="https://github.com/KhronosGroup/Vulkan-Docs/issues/new?title=VK_NV_mesh_shader:%20&amp;body=@pixeljetstream%20">pixeljetstream</a></li>
            </ul></dd>

            <dt><b>Last Modified Date</b></dt>
            <dd>2018-07-19</dd>

            <dt><b>Contributors</b></dt>
            <dd><ul>
                <li>Pat Brown, NVIDIA</li>
                <li>Jeff Bolz, NVIDIA</li>
                <li>Daniel Koch, NVIDIA</li>
                <li>Piers Daniell, NVIDIA</li>
                <li>Pierre Boudier, NVIDIA</li>
            </ul></dd>
        </dl>
        """

    IntConstant(
        "The extension specification version.",

        "NV_MESH_SHADER_SPEC_VERSION".."1"
    )

    StringConstant(
        "The extension name.",

        "NV_MESH_SHADER_EXTENSION_NAME".."VK_NV_mesh_shader"
    )

    EnumConstant(
        "Extends {@code VkStructureType}.",

        "STRUCTURE_TYPE_PHYSICAL_DEVICE_MESH_SHADER_FEATURES_NV".."1000202000",
        "STRUCTURE_TYPE_PHYSICAL_DEVICE_MESH_SHADER_PROPERTIES_NV".."1000202001"
    )

    EnumConstant(
        "Extends {@code VkShaderStageFlagBits}.",

        "SHADER_STAGE_TASK_BIT_NV".enum(0x00000040),
        "SHADER_STAGE_MESH_BIT_NV".enum(0x00000080)
    )

    EnumConstant(
        "Extends {@code VkPipelineStageFlagBits}.",

        "PIPELINE_STAGE_TASK_SHADER_BIT_NV".enum(0x00080000),
        "PIPELINE_STAGE_MESH_SHADER_BIT_NV".enum(0x00100000)
    )

    void(
        "CmdDrawMeshTasksNV",
        """
        Draw mesh task work items.

        <h5>C Specification</h5>
        To record a draw that uses the mesh pipeline, call:

        <pre><code>
￿void vkCmdDrawMeshTasksNV(
￿    VkCommandBuffer                             commandBuffer,
￿    uint32_t                                    taskCount,
￿    uint32_t                                    firstTask);</code></pre>

        <h5>Description</h5>
        When the command is executed, a global workgroup consisting of {@code taskCount} local workgroups is assembled.

        <h5>Valid Usage</h5>
        <ul>
            <li>{@code taskCount} <b>must</b> be less than or equal to ##VkPhysicalDeviceMeshShaderPropertiesNV{@code ::maxDrawMeshTasksCount}</li>
            <li>The current render pass <b>must</b> be <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#renderpass-compatibility">compatible</a> with the {@code renderPass} member of the ##VkGraphicsPipelineCreateInfo structure specified when creating the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS.</li>
            <li>The subpass index of the current render pass <b>must</b> be equal to the {@code subpass} member of the ##VkGraphicsPipelineCreateInfo structure specified when creating the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS.</li>
            <li>For each set <em>n</em> that is statically used by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS, a descriptor set <b>must</b> have been bound to <em>n</em> at #PIPELINE_BIND_POINT_GRAPHICS, with a {@code VkPipelineLayout} that is compatible for set <em>n</em>, with the {@code VkPipelineLayout} used to create the current {@code VkPipeline}, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#descriptorsets-compatibility">the “Pipeline Layout Compatibility” section</a></li>
            <li>For each push constant that is statically used by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS, a push constant value <b>must</b> have been set for #PIPELINE_BIND_POINT_GRAPHICS, with a {@code VkPipelineLayout} that is compatible for push constants, with the {@code VkPipelineLayout} used to create the current {@code VkPipeline}, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#descriptorsets-compatibility">the “Pipeline Layout Compatibility” section</a></li>
            <li>Descriptors in each bound descriptor set, specified via #CmdBindDescriptorSets(), <b>must</b> be valid if they are statically used by the currently bound {@code VkPipeline} object, specified via #CmdBindPipeline()</li>
            <li>A valid graphics pipeline <b>must</b> be bound to the current command buffer with #PIPELINE_BIND_POINT_GRAPHICS</li>
            <li>If the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS requires any dynamic state, that state <b>must</b> have been set on the current command buffer</li>
            <li>Every input attachment used by the current subpass <b>must</b> be bound to the pipeline via a descriptor set</li>
            <li>If any {@code VkSampler} object that is accessed from a shader by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS uses unnormalized coordinates, it <b>must</b> not be used to sample from any {@code VkImage} with a {@code VkImageView} of the type #IMAGE_VIEW_TYPE_3D, #IMAGE_VIEW_TYPE_CUBE, #IMAGE_VIEW_TYPE_1D_ARRAY, #IMAGE_VIEW_TYPE_2D_ARRAY or #IMAGE_VIEW_TYPE_CUBE_ARRAY, in any shader stage</li>
            <li>If any {@code VkSampler} object that is accessed from a shader by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS uses unnormalized coordinates, it <b>must</b> not be used with any of the SPIR-V {@code OpImageSample*} or {@code OpImageSparseSample*} instructions with {@code ImplicitLod}, {@code Dref} or {@code Proj} in their name, in any shader stage</li>
            <li>If any {@code VkSampler} object that is accessed from a shader by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS uses unnormalized coordinates, it <b>must</b> not be used with any of the SPIR-V {@code OpImageSample*} or {@code OpImageSparseSample*} instructions that includes a LOD bias or any offset values, in any shader stage</li>
            <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#features-features-robustBufferAccess">robust buffer access</a> feature is not enabled, and any shader stage in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS accesses a uniform buffer, it <b>must</b> not access values outside of the range of that buffer specified in the currently bound descriptor set</li>
            <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#features-features-robustBufferAccess">robust buffer access</a> feature is not enabled, and any shader stage in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS accesses a storage buffer, it <b>must</b> not access values outside of the range of that buffer specified in the currently bound descriptor set</li>
            <li>Any {@code VkImageView} being sampled with #FILTER_LINEAR as a result of this command <b>must</b> be of a format which supports linear filtering, as specified by the #FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT flag in ##VkFormatProperties{@code ::linearTilingFeatures} (for a linear image) or ##VkFormatProperties{@code ::optimalTilingFeatures}(for an optimally tiled image) returned by #GetPhysicalDeviceFormatProperties()</li>
            <li>Image subresources used as attachments in the current render pass <b>must</b> not be accessed in any way other than as an attachment by this command.</li>
            <li>Any {@code VkImageView} being sampled with #FILTER_CUBIC_IMG as a result of this command <b>must</b> be of a format which supports cubic filtering, as specified by the #FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_CUBIC_BIT_IMG flag in ##VkFormatProperties{@code ::linearTilingFeatures} (for a linear image) or ##VkFormatProperties{@code ::optimalTilingFeatures}(for an optimally tiled image) returned by #GetPhysicalDeviceFormatProperties()</li>
            <li>Any {@code VkImageView} being sampled with #FILTER_CUBIC_IMG as a result of this command <b>must</b> not have a {@code VkImageViewType} of #IMAGE_VIEW_TYPE_3D, #IMAGE_VIEW_TYPE_CUBE, or #IMAGE_VIEW_TYPE_CUBE_ARRAY</li>
            <li>If the draw is recorded in a render pass instance with multiview enabled, the maximum instance index <b>must</b> be less than or equal to ##VkPhysicalDeviceMultiviewProperties{@code ::maxMultiviewInstanceIndex}.</li>
            <li>If {@code commandBuffer} is an unprotected command buffer, and any pipeline stage in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS reads from or writes to any image or buffer, that image or buffer <b>must</b> not be a protected image or protected buffer.</li>
            <li>If {@code commandBuffer} is a protected command buffer, and any pipeline stage in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS writes to any image or buffer, that image or buffer <b>must</b> not be an unprotected image or unprotected buffer.</li>
            <li>If {@code commandBuffer} is a protected command buffer, and any pipeline stage other than the framebuffer-space pipeline stages in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS reads from or writes to any image or buffer, the image or buffer <b>must</b> not be a protected image or protected buffer.</li>
            <li>If the currently bound graphics pipeline was created with ##VkPipelineSampleLocationsStateCreateInfoEXT{@code ::sampleLocationsEnable} set to #TRUE and the current subpass has a depth/stencil attachment, then that attachment <b>must</b> have been created with the #IMAGE_CREATE_SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_BIT_EXT bit set</li>
            <li>Any {@code VkImage} created with a ##VkImageCreateInfo{@code ::flags} containing #IMAGE_CREATE_CORNER_SAMPLED_BIT_NV sampled as a result of this command <b>must</b> only be sampled using a {@code VkSamplerAddressMode} of #SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE.</li>
        </ul>

        <h5>Valid Usage (Implicit)</h5>
        <ul>
            <li>{@code commandBuffer} <b>must</b> be a valid {@code VkCommandBuffer} handle</li>
            <li>{@code commandBuffer} <b>must</b> be in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#commandbuffers-lifecycle">recording state</a></li>
            <li>The {@code VkCommandPool} that {@code commandBuffer} was allocated from <b>must</b> support graphics operations</li>
            <li>This command <b>must</b> only be called inside of a render pass instance</li>
        </ul>

        <h5>Host Synchronization</h5>
        <ul>
            <li>Host access to {@code commandBuffer} <b>must</b> be externally synchronized</li>
            <li>Host access to the {@code VkCommandPool} that {@code commandBuffer} was allocated from <b>must</b> be externally synchronized</li>
        </ul>

        <h5>Command Properties</h5>
        <table class="lwjgl">
            <thead><tr><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#VkCommandBufferLevel">Command Buffer Levels</a></th><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#vkCmdBeginRenderPass">Render Pass Scope</a></th><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#VkQueueFlagBits">Supported Queue Types</a></th><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#synchronization-pipeline-stages-types">Pipeline Type</a></th></tr></thead>
            <tbody><tr><td>Primary Secondary</td><td>Inside</td><td>Graphics</td><td>Graphics</td></tr></tbody>
        </table>
        """,

        VkCommandBuffer.IN("commandBuffer", "the command buffer into which the command will be recorded."),
        uint32_t.IN("taskCount", "the number of local workgroups to dispatch in the X dimension. Y and Z dimension are implicitly set to one."),
        uint32_t.IN("firstTask", "the X component of the first workgroup ID.")
    )

    void(
        "CmdDrawMeshTasksIndirectNV",
        """
        Issue an indirect mesh tasks draw into a command buffer.

        <h5>C Specification</h5>
        To record an indirect mesh tasks draw, call:

        <pre><code>
￿void vkCmdDrawMeshTasksIndirectNV(
￿    VkCommandBuffer                             commandBuffer,
￿    VkBuffer                                    buffer,
￿    VkDeviceSize                                offset,
￿    uint32_t                                    drawCount,
￿    uint32_t                                    stride);</code></pre>

        <h5>Description</h5>
        #CmdDrawMeshTasksIndirectNV() behaves similarly to #CmdDrawMeshTasksNV() except that the parameters are read by the device from a buffer during execution. {@code drawCount} draws are executed by the command, with parameters taken from {@code buffer} starting at {@code offset} and increasing by {@code stride} bytes for each successive draw. The parameters of each draw are encoded in an array of ##VkDrawMeshTasksIndirectCommandNV structures. If {@code drawCount} is less than or equal to one, {@code stride} is ignored.

        <h5>Valid Usage</h5>
        <ul>
            <li>If {@code buffer} is non-sparse then it <b>must</b> be bound completely and contiguously to a single {@code VkDeviceMemory} object</li>
            <li>{@code buffer} <b>must</b> have been created with the #BUFFER_USAGE_INDIRECT_BUFFER_BIT bit set</li>
            <li>{@code offset} <b>must</b> be a multiple of 4</li>
            <li>If {@code drawCount} is greater than 1, {@code stride} <b>must</b> be a multiple of 4 and <b>must</b> be greater than or equal to {@code sizeof}(##VkDrawMeshTasksIndirectCommandNV)</li>
            <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#features-features-multiDrawIndirect">multi-draw indirect</a> feature is not enabled, {@code drawCount} <b>must</b> be 0 or 1</li>
            <li>The current render pass <b>must</b> be <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#renderpass-compatibility">compatible</a> with the {@code renderPass} member of the ##VkGraphicsPipelineCreateInfo structure specified when creating the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS.</li>
            <li>The subpass index of the current render pass <b>must</b> be equal to the {@code subpass} member of the ##VkGraphicsPipelineCreateInfo structure specified when creating the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS.</li>
            <li>For each set <em>n</em> that is statically used by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS, a descriptor set <b>must</b> have been bound to <em>n</em> at #PIPELINE_BIND_POINT_GRAPHICS, with a {@code VkPipelineLayout} that is compatible for set <em>n</em>, with the {@code VkPipelineLayout} used to create the current {@code VkPipeline}, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#descriptorsets-compatibility">the “Pipeline Layout Compatibility” section</a></li>
            <li>For each push constant that is statically used by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS, a push constant value <b>must</b> have been set for #PIPELINE_BIND_POINT_GRAPHICS, with a {@code VkPipelineLayout} that is compatible for push constants, with the {@code VkPipelineLayout} used to create the current {@code VkPipeline}, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#descriptorsets-compatibility">the “Pipeline Layout Compatibility” section</a></li>
            <li>Descriptors in each bound descriptor set, specified via #CmdBindDescriptorSets(), <b>must</b> be valid if they are statically used by the currently bound {@code VkPipeline} object, specified via #CmdBindPipeline()</li>
            <li>All vertex input bindings accessed via vertex input variables declared in the vertex shader entry point&#8217;s interface <b>must</b> have valid buffers bound</li>
            <li>A valid graphics pipeline <b>must</b> be bound to the current command buffer with #PIPELINE_BIND_POINT_GRAPHICS</li>
            <li>If the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS requires any dynamic state, that state <b>must</b> have been set on the current command buffer</li>
            <li>If {@code drawCount} is equal to 1, <code>(offset sizeof(##VkDrawMeshTasksIndirectCommandNV))</code> <b>must</b> be less than or equal to the size of {@code buffer}</li>
            <li>If {@code drawCount} is greater than 1, <code>(stride × (drawCount - 1) + offset sizeof(##VkDrawMeshTasksIndirectCommandNV))</code> <b>must</b> be less than or equal to the size of {@code buffer}</li>
            <li>{@code drawCount} <b>must</b> be less than or equal to ##VkPhysicalDeviceLimits{@code ::maxDrawIndirectCount}</li>
            <li>Every input attachment used by the current subpass <b>must</b> be bound to the pipeline via a descriptor set</li>
            <li>If any {@code VkSampler} object that is accessed from a shader by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS uses unnormalized coordinates, it <b>must</b> not be used to sample from any {@code VkImage} with a {@code VkImageView} of the type #IMAGE_VIEW_TYPE_3D, #IMAGE_VIEW_TYPE_CUBE, #IMAGE_VIEW_TYPE_1D_ARRAY, #IMAGE_VIEW_TYPE_2D_ARRAY or #IMAGE_VIEW_TYPE_CUBE_ARRAY, in any shader stage</li>
            <li>If any {@code VkSampler} object that is accessed from a shader by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS uses unnormalized coordinates, it <b>must</b> not be used with any of the SPIR-V {@code OpImageSample*} or {@code OpImageSparseSample*} instructions with {@code ImplicitLod}, {@code Dref} or {@code Proj} in their name, in any shader stage</li>
            <li>If any {@code VkSampler} object that is accessed from a shader by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS uses unnormalized coordinates, it <b>must</b> not be used with any of the SPIR-V {@code OpImageSample*} or {@code OpImageSparseSample*} instructions that includes a LOD bias or any offset values, in any shader stage</li>
            <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#features-features-robustBufferAccess">robust buffer access</a> feature is not enabled, and any shader stage in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS accesses a uniform buffer, it <b>must</b> not access values outside of the range of that buffer specified in the currently bound descriptor set</li>
            <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#features-features-robustBufferAccess">robust buffer access</a> feature is not enabled, and any shader stage in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS accesses a storage buffer, it <b>must</b> not access values outside of the range of that buffer specified in the currently bound descriptor set</li>
            <li>Any {@code VkImageView} being sampled with #FILTER_LINEAR as a result of this command <b>must</b> be of a format which supports linear filtering, as specified by the #FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT flag in ##VkFormatProperties{@code ::linearTilingFeatures} (for a linear image) or ##VkFormatProperties{@code ::optimalTilingFeatures}(for an optimally tiled image) returned by #GetPhysicalDeviceFormatProperties()</li>
            <li>Image subresources used as attachments in the current render pass <b>must</b> not be accessed in any way other than as an attachment by this command.</li>
            <li>Any {@code VkImageView} being sampled with #FILTER_CUBIC_IMG as a result of this command <b>must</b> be of a format which supports cubic filtering, as specified by the #FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_CUBIC_BIT_IMG flag in ##VkFormatProperties{@code ::linearTilingFeatures} (for a linear image) or ##VkFormatProperties{@code ::optimalTilingFeatures}(for an optimally tiled image) returned by #GetPhysicalDeviceFormatProperties()</li>
            <li>Any {@code VkImageView} being sampled with #FILTER_CUBIC_IMG as a result of this command <b>must</b> not have a {@code VkImageViewType} of #IMAGE_VIEW_TYPE_3D, #IMAGE_VIEW_TYPE_CUBE, or #IMAGE_VIEW_TYPE_CUBE_ARRAY</li>
            <li>If the draw is recorded in a render pass instance with multiview enabled, the maximum instance index <b>must</b> be less than or equal to ##VkPhysicalDeviceMultiviewProperties{@code ::maxMultiviewInstanceIndex}.</li>
            <li>If {@code commandBuffer} is an unprotected command buffer, and any pipeline stage in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS reads from or writes to any image or buffer, that image or buffer <b>must</b> not be a protected image or protected buffer.</li>
            <li>If {@code commandBuffer} is a protected command buffer, and any pipeline stage in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS writes to any image or buffer, that image or buffer <b>must</b> not be an unprotected image or unprotected buffer.</li>
            <li>If {@code commandBuffer} is a protected command buffer, and any pipeline stage other than the framebuffer-space pipeline stages in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS reads from or writes to any image or buffer, the image or buffer <b>must</b> not be a protected image or protected buffer.</li>
            <li>If the currently bound graphics pipeline was created with ##VkPipelineSampleLocationsStateCreateInfoEXT{@code ::sampleLocationsEnable} set to #TRUE and the current subpass has a depth/stencil attachment, then that attachment <b>must</b> have been created with the #IMAGE_CREATE_SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_BIT_EXT bit set</li>
            <li>Any {@code VkImage} created with a ##VkImageCreateInfo{@code ::flags} containing #IMAGE_CREATE_CORNER_SAMPLED_BIT_NV sampled as a result of this command <b>must</b> only be sampled using a {@code VkSamplerAddressMode} of #SAMPLER_ADDRESS_MODE_CLAMP_TO_EDGE.</li>
        </ul>

        <h5>Valid Usage (Implicit)</h5>
        <ul>
            <li>{@code commandBuffer} <b>must</b> be a valid {@code VkCommandBuffer} handle</li>
            <li>{@code buffer} <b>must</b> be a valid {@code VkBuffer} handle</li>
            <li>{@code commandBuffer} <b>must</b> be in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#commandbuffers-lifecycle">recording state</a></li>
            <li>The {@code VkCommandPool} that {@code commandBuffer} was allocated from <b>must</b> support graphics operations</li>
            <li>This command <b>must</b> only be called inside of a render pass instance</li>
            <li>Both of {@code buffer}, and {@code commandBuffer} <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
        </ul>

        <h5>Host Synchronization</h5>
        <ul>
            <li>Host access to {@code commandBuffer} <b>must</b> be externally synchronized</li>
            <li>Host access to the {@code VkCommandPool} that {@code commandBuffer} was allocated from <b>must</b> be externally synchronized</li>
        </ul>

        <h5>Command Properties</h5>
        <table class="lwjgl">
            <thead><tr><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#VkCommandBufferLevel">Command Buffer Levels</a></th><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#vkCmdBeginRenderPass">Render Pass Scope</a></th><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#VkQueueFlagBits">Supported Queue Types</a></th><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#synchronization-pipeline-stages-types">Pipeline Type</a></th></tr></thead>
            <tbody><tr><td>Primary Secondary</td><td>Inside</td><td>Graphics</td><td>Graphics</td></tr></tbody>
        </table>
        """,

        VkCommandBuffer.IN("commandBuffer", "the command buffer into which the command is recorded."),
        VkBuffer.IN("buffer", "the buffer containing draw parameters."),
        VkDeviceSize.IN("offset", "the byte offset into {@code buffer} where parameters begin."),
        uint32_t.IN("drawCount", "the number of draws to execute, and <b>can</b> be zero."),
        uint32_t.IN("stride", "the byte stride between successive sets of draw parameters.")
    )

    void(
        "CmdDrawMeshTasksIndirectCountNV",
        """
        Perform an indirect mesh tasks draw with the draw count sourced from a buffer.

        <h5>C Specification</h5>
        To record an indirect mesh tasks draw with the draw count sourced from a buffer, call:

        <pre><code>
￿void vkCmdDrawMeshTasksIndirectCountNV(
￿    VkCommandBuffer                             commandBuffer,
￿    VkBuffer                                    buffer,
￿    VkDeviceSize                                offset,
￿    VkBuffer                                    countBuffer,
￿    VkDeviceSize                                countBufferOffset,
￿    uint32_t                                    maxDrawCount,
￿    uint32_t                                    stride);</code></pre>

        <h5>Description</h5>
        #CmdDrawMeshTasksIndirectCountNV() behaves similarly to #CmdDrawMeshTasksIndirectNV() except that the draw count is read by the device from a buffer during execution. The command will read an unsigned 32-bit integer from {@code countBuffer} located at {@code countBufferOffset} and use this as the draw count.

        <h5>Valid Usage</h5>
        <ul>
            <li>If {@code buffer} is non-sparse then it <b>must</b> be bound completely and contiguously to a single {@code VkDeviceMemory} object</li>
            <li>{@code buffer} <b>must</b> have been created with the #BUFFER_USAGE_INDIRECT_BUFFER_BIT bit set</li>
            <li>If {@code countBuffer} is non-sparse then it <b>must</b> be bound completely and contiguously to a single {@code VkDeviceMemory} object</li>
            <li>{@code countBuffer} <b>must</b> have been created with the #BUFFER_USAGE_INDIRECT_BUFFER_BIT bit set</li>
            <li>{@code offset} <b>must</b> be a multiple of 4</li>
            <li>{@code countBufferOffset} <b>must</b> be a multiple of 4</li>
            <li>{@code stride} <b>must</b> be a multiple of 4 and <b>must</b> be greater than or equal to {@code sizeof}(##VkDrawMeshTasksIndirectCommandNV)</li>
            <li>If {@code maxDrawCount} is greater than or equal to 1, <code>(stride × (maxDrawCount - 1) + offset + sizeof(##VkDrawMeshTasksIndirectCommandNV))</code> <b>must</b> be less than or equal to the size of {@code buffer}</li>
            <li>The current render pass <b>must</b> be <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#renderpass-compatibility">compatible</a> with the {@code renderPass} member of the ##VkGraphicsPipelineCreateInfo structure specified when creating the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS.</li>
            <li>The subpass index of the current render pass <b>must</b> be equal to the {@code subpass} member of the ##VkGraphicsPipelineCreateInfo structure specified when creating the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS.</li>
            <li>For each set <em>n</em> that is statically used by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS, a descriptor set <b>must</b> have been bound to <em>n</em> at #PIPELINE_BIND_POINT_GRAPHICS, with a {@code VkPipelineLayout} that is compatible for set <em>n</em>, with the {@code VkPipelineLayout} used to create the current {@code VkPipeline}, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#descriptorsets-compatibility">the “Pipeline Layout Compatibility” section</a></li>
            <li>For each push constant that is statically used by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS, a push constant value <b>must</b> have been set for #PIPELINE_BIND_POINT_GRAPHICS, with a {@code VkPipelineLayout} that is compatible for push constants, with the {@code VkPipelineLayout} used to create the current {@code VkPipeline}, as described in <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#descriptorsets-compatibility">the “Pipeline Layout Compatibility” section</a></li>
            <li>Descriptors in each bound descriptor set, specified via #CmdBindDescriptorSets(), <b>must</b> be valid if they are statically used by the currently bound {@code VkPipeline} object, specified via #CmdBindPipeline()</li>
            <li>A valid graphics pipeline <b>must</b> be bound to the current command buffer with #PIPELINE_BIND_POINT_GRAPHICS</li>
            <li>If the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS requires any dynamic state, that state <b>must</b> have been set on the current command buffer</li>
            <li>If the count stored in {@code countBuffer} is equal to 1, <code>(offset sizeof(##VkDrawMeshTasksIndirectCommandNV))</code> <b>must</b> be less than or equal to the size of {@code buffer}</li>
            <li>If the count stored in {@code countBuffer} is greater than 1, <code>(stride × (drawCount - 1) + offset + sizeof(##VkDrawMeshTasksIndirectCommandNV))</code> <b>must</b> be less than or equal to the size of {@code buffer}</li>
            <li>The count stored in {@code countBuffer} <b>must</b> be less than or equal to ##VkPhysicalDeviceLimits{@code ::maxDrawIndirectCount}</li>
            <li>Every input attachment used by the current subpass <b>must</b> be bound to the pipeline via a descriptor set</li>
            <li>If any {@code VkSampler} object that is accessed from a shader by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS uses unnormalized coordinates, it <b>must</b> not be used to sample from any {@code VkImage} with a {@code VkImageView} of the type #IMAGE_VIEW_TYPE_3D, #IMAGE_VIEW_TYPE_CUBE, #IMAGE_VIEW_TYPE_1D_ARRAY, #IMAGE_VIEW_TYPE_2D_ARRAY or #IMAGE_VIEW_TYPE_CUBE_ARRAY, in any shader stage</li>
            <li>If any {@code VkSampler} object that is accessed from a shader by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS uses unnormalized coordinates, it <b>must</b> not be used with any of the SPIR-V {@code OpImageSample*} or {@code OpImageSparseSample*} instructions with {@code ImplicitLod}, {@code Dref} or {@code Proj} in their name, in any shader stage</li>
            <li>If any {@code VkSampler} object that is accessed from a shader by the {@code VkPipeline} currently bound to #PIPELINE_BIND_POINT_GRAPHICS uses unnormalized coordinates, it <b>must</b> not be used with any of the SPIR-V {@code OpImageSample*} or {@code OpImageSparseSample*} instructions that includes a LOD bias or any offset values, in any shader stage</li>
            <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#features-features-robustBufferAccess">robust buffer access</a> feature is not enabled, and any shader stage in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS accesses a uniform buffer, it <b>must</b> not access values outside of the range of that buffer specified in the currently bound descriptor set</li>
            <li>If the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#features-features-robustBufferAccess">robust buffer access</a> feature is not enabled, and any shader stage in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS accesses a storage buffer, it <b>must</b> not access values outside of the range of that buffer specified in the currently bound descriptor set</li>
            <li>Any {@code VkImageView} being sampled with #FILTER_LINEAR as a result of this command <b>must</b> be of a format which supports linear filtering, as specified by the #FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT flag in ##VkFormatProperties{@code ::linearTilingFeatures} (for a linear image) or ##VkFormatProperties{@code ::optimalTilingFeatures}(for an optimally tiled image) returned by #GetPhysicalDeviceFormatProperties()</li>
            <li>Image subresources used as attachments in the current render pass <b>must</b> not be accessed in any way other than as an attachment by this command.</li>
            <li>If the draw is recorded in a render pass instance with multiview enabled, the maximum instance index <b>must</b> be less than or equal to ##VkPhysicalDeviceMultiviewProperties{@code ::maxMultiviewInstanceIndex}.</li>
            <li>If {@code commandBuffer} is an unprotected command buffer, and any pipeline stage in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS reads from or writes to any image or buffer, that image or buffer <b>must</b> not be a protected image or protected buffer.</li>
            <li>If {@code commandBuffer} is a protected command buffer, and any pipeline stage in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS writes to any image or buffer, that image or buffer <b>must</b> not be an unprotected image or unprotected buffer.</li>
            <li>If {@code commandBuffer} is a protected command buffer, and any pipeline stage other than the framebuffer-space pipeline stages in the {@code VkPipeline} object currently bound to #PIPELINE_BIND_POINT_GRAPHICS reads from or writes to any image or buffer, the image or buffer <b>must</b> not be a protected image or protected buffer.</li>
            <li>If the currently bound graphics pipeline was created with ##VkPipelineSampleLocationsStateCreateInfoEXT{@code ::sampleLocationsEnable} set to #TRUE and the current subpass has a depth/stencil attachment, then that attachment <b>must</b> have been created with the #IMAGE_CREATE_SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_BIT_EXT bit set</li>
        </ul>

        <h5>Valid Usage (Implicit)</h5>
        <ul>
            <li>{@code commandBuffer} <b>must</b> be a valid {@code VkCommandBuffer} handle</li>
            <li>{@code buffer} <b>must</b> be a valid {@code VkBuffer} handle</li>
            <li>{@code countBuffer} <b>must</b> be a valid {@code VkBuffer} handle</li>
            <li>{@code commandBuffer} <b>must</b> be in the <a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#commandbuffers-lifecycle">recording state</a></li>
            <li>The {@code VkCommandPool} that {@code commandBuffer} was allocated from <b>must</b> support graphics operations</li>
            <li>This command <b>must</b> only be called inside of a render pass instance</li>
            <li>Each of {@code buffer}, {@code commandBuffer}, and {@code countBuffer} <b>must</b> have been created, allocated, or retrieved from the same {@code VkDevice}</li>
        </ul>

        <h5>Host Synchronization</h5>
        <ul>
            <li>Host access to {@code commandBuffer} <b>must</b> be externally synchronized</li>
            <li>Host access to the {@code VkCommandPool} that {@code commandBuffer} was allocated from <b>must</b> be externally synchronized</li>
        </ul>

        <h5>Command Properties</h5>
        <table class="lwjgl">
            <thead><tr><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#VkCommandBufferLevel">Command Buffer Levels</a></th><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#vkCmdBeginRenderPass">Render Pass Scope</a></th><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#VkQueueFlagBits">Supported Queue Types</a></th><th><a target="_blank" href="https://www.khronos.org/registry/vulkan/specs/1.0-extensions/html/vkspec.html\#synchronization-pipeline-stages-types">Pipeline Type</a></th></tr></thead>
            <tbody><tr><td>Primary Secondary</td><td>Inside</td><td>Graphics</td><td>Graphics</td></tr></tbody>
        </table>
        """,

        VkCommandBuffer.IN("commandBuffer", "the command buffer into which the command is recorded."),
        VkBuffer.IN("buffer", "the buffer containing draw parameters."),
        VkDeviceSize.IN("offset", "the byte offset into {@code buffer} where parameters begin."),
        VkBuffer.IN("countBuffer", "the buffer containing the draw count."),
        VkDeviceSize.IN("countBufferOffset", "the byte offset into {@code countBuffer} where the draw count begins."),
        uint32_t.IN("maxDrawCount", "specifies the maximum number of draws that will be executed. The actual number of executed draw calls is the minimum of the count specified in {@code countBuffer} and {@code maxDrawCount}."),
        uint32_t.IN("stride", "the byte stride between successive sets of draw parameters.")
    )
}